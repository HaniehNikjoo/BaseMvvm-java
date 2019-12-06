package com.example.basemvvm.di.module;

import com.example.basemvvm.di.ActivityScoped;
import com.example.basemvvm.view.demo.ActivityDemo;
import com.example.basemvvm.view.demo.di.DemoModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by amir on 11/12/17.
 */

@Module
public abstract class ActivityBindersModule {

//    @ActivityScoped
//    @ContributesAndroidInjector
//    abstract ActivityDemo bindActivityAboutUs();
//
    @ActivityScoped
    @ContributesAndroidInjector(modules = DemoModule.class)
    abstract ActivityDemo bindActivityAboutUs();

}
