package com.asuscomm.yangyinetwork.dbexample.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

@DatabaseTable(tableName = "sensor_datas")
public class SensorData {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField
    String device;
    @DatabaseField
    double value;

    public SensorData() {
        // ORMLite 필수
    }

    public SensorData(String device, double value) {
        this.device = device;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", device='" + device + '\'' +
                ", value=" + value +
                '}';
    }
}
