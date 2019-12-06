package com.example.basemvvm.demo.di;

import android.arch.lifecycle.ViewModelProviders;

import com.example.basemvvm.view.demo.ActivityDemo;
import com.example.basemvvm.view.demo.DemoViewModel;
import com.example.basemvvm.view.demo.DemoViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DemoModule {

    @Provides
    static DemoViewModel provideViewModel(ActivityDemo activity, DemoViewModelFactory factory){
        return ViewModelProviders.of(activity,factory).get(DemoViewModel.class);
    }
}
