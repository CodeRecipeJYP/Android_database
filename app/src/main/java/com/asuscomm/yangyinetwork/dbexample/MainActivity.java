package com.asuscomm.yangyinetwork.dbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.SensorData;
import com.asuscomm.yangyinetwork.dbexample.repos.local.OrmHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OrmHelper ormHelper = new OrmHelper(this);
        RuntimeExceptionDao<SensorData, Integer> sensorDataDao = ormHelper.getSensorDataDao();

        SensorData sensorData = new SensorData();
        sensorDataDao.create(sensorData);
        List<SensorData> sensorDatas = sensorDataDao.queryForAll();

        Log.d(TAG, "onCreate: sensorDatas="+sensorDatas.size());
//        sensorDataDao.delete();
//        sensorDataDao.update();
    }
}
