package com.hs.cathaybankexam.area.AreaDetail.di;

import com.hs.cathaybankexam.area.AreaDetail.AreaDetailFragment;
import com.hs.cathaybankexam.area.AreaList.di.AreaModule;
import com.hs.cathaybankexam.di.component.AppComponent;
import com.hs.cathaybankexam.di.scoped.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(modules = AreaDetailModule.class, dependencies = AppComponent.class)
public interface AreaDetailComponent {
    void inject(AreaDetailFragment areaDetailFragment);
}
