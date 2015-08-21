package com.johannfjs.application;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by johannfjs on 18/08/15.
 */
public class Configuration extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
