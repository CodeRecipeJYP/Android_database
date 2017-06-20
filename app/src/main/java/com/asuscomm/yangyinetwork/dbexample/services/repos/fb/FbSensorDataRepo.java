package com.asuscomm.yangyinetwork.dbexample.services.repos.fb;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class FbSensorDataRepo {
    private static FbSensorDataRepo mInstance;

    public static FbSensorDataRepo getInstance() {
        if (mInstance == null) {
            mInstance = new FbSensorDataRepo();
        }

        return mInstance;
    }
}
