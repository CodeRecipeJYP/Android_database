package com.asuscomm.yangyinetwork.dbexample.services;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class SensorDataDao {
    private static SensorDataDao mInstance;

    public SensorDataDao() {
    }

    public static SensorDataDao getInstance() {
        if (mInstance == null) {
            mInstance = new SensorDataDao();
        }
        return mInstance;
    }

}
