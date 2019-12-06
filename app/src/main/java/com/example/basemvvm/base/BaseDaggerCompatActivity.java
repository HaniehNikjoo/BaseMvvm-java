package com.example.basemvvm.base;

import android.annotation.SuppressLint;
import android.support.annotation.StringRes;
import android.widget.Toast;

import dagger.android.support.DaggerAppCompatActivity;


@SuppressLint("Registered")
public abstract class BaseDaggerCompatActivity extends DaggerAppCompatActivity {

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int string){
        Toast.makeText(this, getString(string), Toast.LENGTH_SHORT).show();
    }

}
