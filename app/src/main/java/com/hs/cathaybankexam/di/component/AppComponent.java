package com.hs.cathaybankexam.di.component;

import android.app.Application;

import com.hs.cathaybankexam.di.AppModule;
import com.hs.cathaybankexam.di.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
//    void inject(RepositoryManager repositoryManager);

//    void inject(AppRemoteDataStore appRemoteDataStore);

    Application getApplication();

    Retrofit getRetrofit();

}

