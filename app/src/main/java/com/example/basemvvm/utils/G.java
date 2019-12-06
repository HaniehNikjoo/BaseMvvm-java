package com.example.basemvvm.utils;

import android.app.Activity;
import android.content.Context;


import com.example.basemvvm.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

public class G extends DaggerApplication {

    public static Context context;
    private static G mInstance;

    public G() {
        mInstance = this;
    }

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static synchronized G getInstance() {
        return mInstance;
    }
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
