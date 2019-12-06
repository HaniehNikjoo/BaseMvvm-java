package com.example.basemvvm.demo.di;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.basemvvm.base.BaseViewModelFactory;

import javax.inject.Inject;


public class DemoViewModelFactory extends BaseViewModelFactory {

    @Inject
    public DemoViewModelFactory(){

    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new DemoViewModel(mRestManager,mPrefManager,mDisposables,mSchedulersFacade,mToastLiveData);
    }
}
