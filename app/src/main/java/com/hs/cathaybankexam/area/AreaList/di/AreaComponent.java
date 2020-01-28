package com.hs.cathaybankexam.area.AreaList.di;

import com.hs.cathaybankexam.area.AreaList.AreaListFragment;
import com.hs.cathaybankexam.di.component.AppComponent;
import com.hs.cathaybankexam.di.scoped.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(modules = AreaModule.class, dependencies = AppComponent.class)
public interface AreaComponent {
    void inject(AreaListFragment areaListFragment);
}
