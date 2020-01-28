package com.hs.cathaybankexam.area.AreaDetail;

import com.hs.cathaybankexam.network.responce.PlantResponse;
import com.hs.cathaybankexam.presenter.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AreaDetailPresenter extends BasePresenter<AreaDetailContract.View> implements AreaDetailContract.Presenter {

    private AreaDetailRepo areaDetailRepo;
    private CompositeDisposable compositeDisposable;

    @Inject
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
                getView().showProgressing(false);
                PlantResponse.ResultResponse result = plantResponse.getResult();

                if(result.getResults().size() == 0) {
                    getView().onGetPlantDataFail();
                    return;
                }
                getView().onGetPlantDataSuccess(result.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {
                getView().showProgressing(false);
                getView().onGetPlantDataError(throwable);
            }
        }));
    }
}
