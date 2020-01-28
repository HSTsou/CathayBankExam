package com.hs.cathaybankexam;

import android.app.Application;

import com.hs.cathaybankexam.constants.ApiConfig;
import com.hs.cathaybankexam.di.AppModule;
import com.hs.cathaybankexam.di.NetworkModule;
import com.hs.cathaybankexam.di.component.AppComponent;
import com.hs.cathaybankexam.di.component.DaggerAppComponent;


public class MyApplication extends Application {
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(ApiConfig.BASE_URL))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
