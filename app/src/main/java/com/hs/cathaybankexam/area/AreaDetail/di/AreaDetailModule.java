package com.hs.cathaybankexam.area.AreaDetail.di;

import com.hs.cathaybankexam.area.AreaDetail.AreaDetailContract;
import com.hs.cathaybankexam.area.AreaDetail.AreaDetailRepo;
import com.hs.cathaybankexam.area.AreaDetail.AreaDetailRepoImpl;
import com.hs.cathaybankexam.network.request.PlantRequest;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AreaDetailModule {
    private AreaDetailContract.View view;

    public AreaDetailModule(AreaDetailContract.View view) {
        this.view = view;
    }

    @Provides
    AreaDetailContract.View provideAreaView() {
        return view;
    }

    @Provides
    AreaDetailRepo provideAreaDetailRepo(Retrofit retrofit) {
        return new AreaDetailRepoImpl(retrofit.create(PlantRequest.class));
    }


}
