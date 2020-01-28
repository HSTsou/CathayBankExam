package com.hs.cathaybankexam.area.AreaList;


import android.util.Log;

import com.hs.cathaybankexam.network.responce.AreaResponse;
import com.hs.cathaybankexam.presenter.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AreaPresenter extends BasePresenter<AreaContract.View> implements AreaContract.Presenter {

    private AreaRepo areaRepo;
    private CompositeDisposable compositeDisposable;

    @Inject
    public AreaPresenter(AreaContract.View view, AreaRepo repo) {
        super(view);
        areaRepo = repo;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void destroy() {
        super.destroy();
        compositeDisposable.clear();
    }

    @Override
    public void getAreaData() {
        if (!isViewAttached()) {
            return;
        }

        getView().showProgressing(true);

        compositeDisposable.add(areaRepo.getAreaData(new AreaRepo.GetAreaDataCallback() {
            @Override
            public void onSuccess(AreaResponse areaResponse) {
                getView().showProgressing(false);
                AreaResponse.ResultResponse resultResponse = areaResponse.getResult();

                if(resultResponse.getResults().size() == 0) {
                    getView().onGetAreaDataFail();
                    return;
                }
                getView().onGetAreaDataSuccess(resultResponse.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.i("HS", "onFailure" + throwable);
                getView().showProgressing(false);
                getView().onGetAreaDataError(throwable);
            }
        }));
    }
}
