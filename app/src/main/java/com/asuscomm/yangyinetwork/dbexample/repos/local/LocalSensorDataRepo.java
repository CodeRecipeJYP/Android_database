package com.asuscomm.yangyinetwork.dbexample.repos.local;

import android.content.Context;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.SensorData;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class LocalSensorDataRepo {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static LocalSensorDataRepo mInstance;
    private RuntimeExceptionDao<SensorData, Integer> sensorDataDao;

    public static void init(Context context) {
        OrmHelper ormHelper = new OrmHelper(context);
        mInstance = new LocalSensorDataRepo();
        mInstance.setSensorDataDao(ormHelper.getSensorDataDao());
    }

    public static LocalSensorDataRepo getInstance() {
        Log.d("jaeyoung/"+LocalSensorDataRepo.class.getName(), "getInstance: ");
        if (mInstance == null) {
            throw new ExceptionInInitializerError("LocalSensorDataRepo InInitialized Error");
        }

        return mInstance;
    }

    public void setSensorDataDao(RuntimeExceptionDao<SensorData, Integer> sensorDataDao) {
        Log.d(TAG, "setSensorDataDao: ");
        this.sensorDataDao = sensorDataDao;
    }

    public void update(SensorData sensorData) {
        Log.d(TAG, "update: before="+sensorData.toString());
        sensorData.setValue(sensorData.getValue()+2000);
        Log.d(TAG, "update: after ="+sensorData.toString());
        sensorDataDao.update(sensorData);
    }

    public void delete(SensorData sensorData) {
        Log.d(TAG, "delete: "+sensorData.toString());
        sensorDataDao.delete(sensorData);
    }

    public void save(String device, double value) {
        SensorData sensorData = new SensorData(device, value);
        save(sensorData);
    }

    public void save(SensorData sensorData) {
        Log.d(TAG, "save: "+sensorData.toString());
        sensorDataDao.create(sensorData);
    }

    public List<SensorData> read() {
        List<SensorData> sensorDatas = sensorDataDao.queryForAll();
        Log.d(TAG, "read: sensorDatas="+sensorDatas.toString());
        return sensorDatas;
    }
}
