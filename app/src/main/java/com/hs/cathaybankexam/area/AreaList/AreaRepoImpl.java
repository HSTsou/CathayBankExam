package com.hs.cathaybankexam.area.AreaList;


import android.util.Log;

import com.hs.cathaybankexam.network.RetrofitServiceGenerator;
import com.hs.cathaybankexam.network.request.AreaRequest;
import com.hs.cathaybankexam.network.responce.AreaResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AreaRepoImpl implements AreaRepo {
    private AreaRequest areaRequest;

    AreaRepoImpl(AreaRequest areaRequest) {
        this.areaRequest = areaRequest;
    }


    @Override
    public Disposable getAreaData(final GetAreaDataCallback callback) {
        return areaRequest.getAreaData("resourceAquire", "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a", 0, 0)
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AreaResponse>() {
                    @Override
                    public void accept(AreaResponse areaResponse) {
                        callback.onSuccess(areaResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        callback.onFailure(throwable);
                    }
                });
    }
}
