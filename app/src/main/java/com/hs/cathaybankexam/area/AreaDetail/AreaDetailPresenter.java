package com.hs.cathaybankexam.area.AreaDetail;

import android.util.Log;

import com.hs.cathaybankexam.network.responce.PlantResponse;
import com.hs.cathaybankexam.presenter.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AreaDetailPresenter extends BasePresenter<AreaDetailContract.View> implements AreaDetailContract.Presenter {

    private AreaDetailRepo areaDetailRepo;
    private CompositeDisposable compositeDisposable;

    public AreaDetailPresenter(AreaDetailContract.View view, AreaDetailRepo repo) {
        super(view);
        areaDetailRepo = repo;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void destroy() {
        super.destroy();
        compositeDisposable.clear();
    }

    @Override
    public void getAreaDetailPlantData(String areaName) {
        if (!isViewAttached()) {
            return;
        }

        getView().showProgressing(true);

        compositeDisposable.add(areaDetailRepo.getPlantData(areaName, new AreaDetailRepo.GetPlantDataCallback() {
            @Override
            public void onSuccess(PlantResponse plantResponse) {
                PlantResponse.ResultResponse result = plantResponse.getResult();
                getView().showProgressing(false);
                getView().onGetPlantDataSuccess(result.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {
                getView().showProgressing(false);
            }
        }));
    }
}
