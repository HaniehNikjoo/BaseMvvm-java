package com.example.basemvvm.base;


import android.arch.lifecycle.ViewModelProvider;

import com.example.basemvvm.network.RestManager;
import com.example.basemvvm.utils.SchedulersFacade;
import com.example.basemvvm.utils.SingleLiveData;
import com.example.basemvvm.utils.prefs.PreferencesManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    protected PreferencesManager mPrefManager;
    @Inject
    protected RestManager mRestManager;
    @Inject
    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mDisposables;
    @Inject
    protected SingleLiveData<Integer> mToastLiveData;

}
