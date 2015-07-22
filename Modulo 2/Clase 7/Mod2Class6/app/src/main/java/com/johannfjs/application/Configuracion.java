package com.johannfjs.application;

import android.app.Application;
//import android.support.multidex.MultiDex;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseUser;

/**
 * Created by johannfjs on 16/07/15.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //MultiDex.install(getApplicationContext());
        // Initialize Crash Reporting.
        ParseCrashReporting.enable(this);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "BWXbqCdm94z0rRYWxSBodMbwsFsirvnXfVPk3ead", "bZkOZNpEnmMAjvhyJ4clxXZDLLOMK3JRuRqzN4hD");


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
