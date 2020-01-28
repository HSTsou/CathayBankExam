package com.hs.cathaybankexam.area.AreaDetail;

import com.hs.cathaybankexam.network.request.PlantRequest;
import com.hs.cathaybankexam.network.responce.PlantResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AreaDetailRepoImpl implements AreaDetailRepo {

    private PlantRequest plantRequest;

    public AreaDetailRepoImpl(PlantRequest plantRequest) {
        this.plantRequest = plantRequest;
    }

    @Override
    public Disposable getPlantData(String areaName, final GetPlantDataCallback callback) {
        return plantRequest.getPlantData("resourceAquire", "f18de02f-b6c9-47c0-8cda-50efad621c14", areaName, 0, 0)
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PlantResponse>() {
                    @Override
                    public void accept(PlantResponse plantResponse) {
                        callback.onSuccess(plantResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        callback.onFailure(throwable);
                    }
                });
    }
}
