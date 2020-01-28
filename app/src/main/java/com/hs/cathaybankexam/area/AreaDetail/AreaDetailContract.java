package com.hs.cathaybankexam.area.AreaDetail;

import com.hs.cathaybankexam.model.Plant;

import java.util.List;

public interface AreaDetailContract {
    interface View {

        void onGetPlantDataSuccess(List<Plant> plants);

        void onGetPlantDataFail();

        void onGetPlantDataError(Throwable throwable);

        void showProgressing(boolean show);
    }

    interface Presenter {

        void getAreaDetailPlantData(String areaName);

    }
}
