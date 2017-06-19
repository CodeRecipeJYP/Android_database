package com.asuscomm.yangyinetwork.dbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.SensorData;
import com.asuscomm.yangyinetwork.dbexample.repos.local.OrmHelper;
import com.facebook.stetho.Stetho;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private RuntimeExceptionDao<SensorData, Integer> sensorDataDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStetho();

        initDb();

        save("aduino1",50);

        read();
//        sensorDataDao.delete();
//        sensorDataDao.update();
    }

    private void initStetho() {
        if(BuildConfig.DEBUG) {
            Log.d(TAG, "initStetho: ");
            Stetho.initializeWithDefaults(this);
        }
    }

    private void save(String device, double value) {
        SensorData sensorData = new SensorData(device, value);
        sensorDataDao.create(sensorData);
    }

    private void read() {
        List<SensorData> sensorDatas = sensorDataDao.queryForAll();
        Log.d(TAG, "read: sensorDatas="+sensorDatas.toString());
    }

    private void initDb() {
        OrmHelper ormHelper = new OrmHelper(this);
        sensorDataDao = ormHelper.getSensorDataDao();
    }
}
