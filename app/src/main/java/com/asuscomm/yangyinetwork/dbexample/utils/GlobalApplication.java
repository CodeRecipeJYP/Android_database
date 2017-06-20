package com.asuscomm.yangyinetwork.dbexample.utils;

import android.app.Application;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.BuildConfig;
import com.asuscomm.yangyinetwork.dbexample.services.repos.local.LocalSensorDataRepo;
import com.facebook.stetho.Stetho;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class GlobalApplication extends Application {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        initDb();

        if (BuildConfig.DEBUG) {
            initStetho();
        }
    }

    private void initDb() {
        Log.d(TAG, "initDb: ");
        LocalSensorDataRepo.init(this);
    }

    private void initStetho() {
        Log.d(TAG, "initStetho: ");
        Stetho.initializeWithDefaults(this);
    }
}
