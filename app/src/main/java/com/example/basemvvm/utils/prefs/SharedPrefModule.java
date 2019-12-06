package com.example.basemvvm.utils.prefs;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.basemvvm.utils.G;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {

    @Provides
    static SharedPreferences provideSharedPrefs(G context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
