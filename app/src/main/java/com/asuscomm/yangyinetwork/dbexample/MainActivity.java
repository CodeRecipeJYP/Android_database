package com.asuscomm.yangyinetwork.dbexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.db.SensorData;
import com.asuscomm.yangyinetwork.dbexample.models.dto.Device;
import com.asuscomm.yangyinetwork.dbexample.models.dto.DeviceDto;
import com.asuscomm.yangyinetwork.dbexample.services.network.KtIotMakerNetwork;
import com.asuscomm.yangyinetwork.dbexample.services.repos.local.LocalSensorDataRepo;
import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.KtIotMakerOpenApiService;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KtIotMakerNetwork.getInstance().getToken(new KtIotMakerNetwork.OnSuccessListener() {
            @Override
            public void onSuccess(Object result) {
                Log.d(TAG, "onSuccess: getToken="+result.toString());
            }
        });

        KtIotMakerNetwork.getInstance().getDevices(new KtIotMakerNetwork.OnSuccessListener() {
            @Override
            public void onSuccess(Object result) {
                Log.d(TAG, "onSuccess: getDevices="+result.toString());

                DeviceDto deviceDto = (DeviceDto) result;
                List<Device> devices = deviceDto.getData();
                Device device = devices.get(0);
                String deviceId = device.getId();
                KtIotMakerNetwork.getInstance().getStream(deviceId, new KtIotMakerNetwork.OnSuccessListener() {
                    @Override
                    public void onSuccess(Object result) {
                        Log.d(TAG, "onSuccess: getStream="+result.toString());
                    }
                });
            }
        });

        // DB
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
        LocalSensorDataRepo.getInstance().delete(sensorData);
    }

    private void update() {
        List<SensorData> sensorDatas = LocalSensorDataRepo.getInstance().read();
        SensorData sensorData = sensorDatas.get(0);
        Log.d(TAG, "update: before=" + sensorData.toString());
        sensorData.setValue(sensorData.getValue()+2000);
        Log.d(TAG, "update: after =" + sensorData.toString());
        LocalSensorDataRepo.getInstance().update(sensorData);
    }
}
