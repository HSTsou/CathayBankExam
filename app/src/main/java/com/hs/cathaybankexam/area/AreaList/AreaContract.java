package com.hs.cathaybankexam.area.AreaList;

import com.hs.cathaybankexam.model.Area;

import java.util.List;


public interface AreaContract {
    interface View {

        void onGetAreaDataSuccess(List<Area> areas);

        void onGetAreaDataFail();

        void onGetAreaDataError(Throwable throwable);

        void showProgressing(boolean show);
    }

    interface Presenter {

        void getAreaData();

    }
}
