package com.example.basemvvm.utils.prefs;


import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreferencesManager implements PreferencesManager {
    private static final String PREF_KEY_NAME = "PREF_KEY_NAME";


    @Inject
    SharedPreferences mPrefs;


    @SuppressWarnings("WeakerAccess")
    @Inject
    public AppPreferencesManager() {

    }

    @Override
    public String getName() {
        return mPrefs.getString(PREF_KEY_NAME, null);
    }

    @Override
    public void setName(String fatherName) {
        mPrefs.edit().putString(PREF_KEY_NAME, fatherName).apply();
    }
}
