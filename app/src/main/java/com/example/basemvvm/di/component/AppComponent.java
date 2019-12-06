package com.example.basemvvm.di.component;

import com.example.basemvvm.di.module.ActivityBindersModule;
import com.example.basemvvm.di.module.AppModule;
import com.example.basemvvm.utils.G;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by HN on 9/15/2018.
 */

@Component(modules = {AppModule.class,
        AndroidSupportInjectionModule.class,
        ActivityBindersModule.class
})
@Singleton
public interface AppComponent extends AndroidInjector<G> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<G> {
    }

    void inject(G app);
}
