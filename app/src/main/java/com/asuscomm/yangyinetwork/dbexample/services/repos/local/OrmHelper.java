package com.asuscomm.yangyinetwork.dbexample.services.repos.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.asuscomm.yangyinetwork.dbexample.models.SensorData;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class OrmHelper extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME = "sensor.db";
    private static final int DB_VERSION = 1;

    private RuntimeExceptionDao sensorDataDao;

    public OrmHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, SensorData.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RuntimeExceptionDao<SensorData, Integer> getSensorDataDao() {
        if(sensorDataDao == null) {
            sensorDataDao = getRuntimeExceptionDao(SensorData.class);
        }

        return sensorDataDao;
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, SensorData.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
        sensorDataDao = null;
    }
}
