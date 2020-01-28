package com.hs.cathaybankexam.area.AreaList.di;

import com.hs.cathaybankexam.area.AreaList.AreaContract;
import com.hs.cathaybankexam.area.AreaList.AreaRepo;
import com.hs.cathaybankexam.area.AreaList.AreaRepoImpl;
import com.hs.cathaybankexam.network.request.AreaRequest;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AreaModule {
    private AreaContract.View view;

    public AreaModule(AreaContract.View view) {
        this.view = view;
    }

    @Provides
    AreaContract.View provideAreaView() {
        return view;
    }

    @Provides
    AreaRepo provideAreaRepo(Retrofit retrofit) {
        return new AreaRepoImpl(retrofit.create(AreaRequest.class));
    }


}