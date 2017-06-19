package com.asuscomm.yangyinetwork.dbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.SensorData;
import com.asuscomm.yangyinetwork.dbexample.repos.local.LocalSensorDataRepo;
import com.asuscomm.yangyinetwork.dbexample.repos.local.OrmHelper;
import com.facebook.stetho.Stetho;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save("aduino1",50);
        read();
        delete();
        update();
    }

    private void save(String device, double value) {
        Log.d(TAG, "save: ");
        LocalSensorDataRepo.getInstance().save(device, value);
    }

    private void read() {
        List<SensorData> sensorDatas = LocalSensorDataRepo.getInstance().read();
        Log.d(TAG, "read: "+sensorDatas.toString());
    }

    private void delete() {
        List<SensorData> sensorDatas = LocalSensorDataRepo.getInstance().read();
        SensorData sensorData = sensorDatas.get(0);
        Log.d(TAG, "delete: " + sensorData.toString());
    }

    private void update() {
        List<SensorData> sensorDatas = LocalSensorDataRepo.getInstance().read();
        SensorData sensorData = sensorDatas.get(0);
        Log.d(TAG, "update: before=" + sensorData.toString());
        sensorData.setValue(sensorData.getValue()+2000);
        Log.d(TAG, "update: after =" + sensorData.toString());
    }
}
