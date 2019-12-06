package com.example.basemvvm.di.module;

import com.example.basemvvm.network.AppRestManager;
import com.example.basemvvm.network.RestManager;
import com.example.basemvvm.utils.SingleLiveData;
import com.example.basemvvm.utils.prefs.AppPreferencesManager;
import com.example.basemvvm.utils.prefs.PreferencesManager;
import com.example.basemvvm.utils.prefs.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by HN on 9/15/2018.
 */

@Module(includes = {SharedPrefModule.class
        , ApiModule.class
//        ,NetworkModule.class
})
public abstract class AppModule {

    @Binds
    @Singleton
    abstract PreferencesManager providePrefManager(AppPreferencesManager prefManager);

    @Binds
    @Singleton
    abstract RestManager provideRestManager(AppRestManager restfManager);

    @Provides
    static CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    static SingleLiveData<Integer> provideIntegerSingleLiveData(){
        return new SingleLiveData<>();
    }

}
