package com.asuscomm.yangyinetwork.dbexample.repos.local;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class LocalSensorDataRepo {
    private static LocalSensorDataRepo mInstance;

    public static LocalSensorDataRepo getInstance() {
        if (mInstance == null) {
            mInstance = new LocalSensorDataRepo();
        }

        return mInstance;
    }
}
