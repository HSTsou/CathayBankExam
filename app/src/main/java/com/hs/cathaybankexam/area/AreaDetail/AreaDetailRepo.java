package com.hs.cathaybankexam.area.AreaDetail;

import com.hs.cathaybankexam.network.responce.PlantResponse;

import io.reactivex.disposables.Disposable;

public interface AreaDetailRepo {
    interface GetPlantDataCallback {

        void onSuccess(PlantResponse plantResponse);

        void onFailure(Throwable throwable);
    }

    Disposable getPlantData(String areaName, AreaDetailRepo.GetPlantDataCallback callback);
}
