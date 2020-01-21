package com.hs.cathaybankexam.area;

import com.hs.cathaybankexam.network.responce.AreaResponse;

import io.reactivex.disposables.Disposable;

public interface AreaRepo {

    interface GetAreaDataCallback {

        void onSuccess(AreaResponse areaResponse);

        void onFailure(Throwable throwable);
    }

    Disposable getAreaData(GetAreaDataCallback callback);

}


