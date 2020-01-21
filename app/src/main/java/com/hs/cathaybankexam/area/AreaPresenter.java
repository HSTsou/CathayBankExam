package com.hs.cathaybankexam.area;


import android.util.Log;

import com.hs.cathaybankexam.network.responce.AreaResponse;
import com.hs.cathaybankexam.presenter.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AreaPresenter extends BasePresenter<AreaContract.View> implements AreaContract.Presenter {

    private AreaRepo areaRepo;
    private Disposable disposable;

    public AreaPresenter(AreaContract.View view, AreaRepo repo) {
        super(view);
        areaRepo = repo;
        disposable = new CompositeDisposable();
    }

    @Override
    public void getAreaData() {
        if (!isViewAttached()) {
            return;
        }

        getView().showProgressing(true);

        areaRepo.getAreaData(new AreaRepo.GetAreaDataCallback() {
            @Override
            public void onSuccess(AreaResponse areaResponse) {
                AreaResponse.ResultResponse resultResponse = areaResponse.getResult();
                getView().showProgressing(false);
                getView().onGetAreaDataSuccess(resultResponse.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.i("HS", "onFailure" + throwable);
                getView().showProgressing(false);
                getView().onGetAreaDataError(throwable);
            }
        });
    }
}
