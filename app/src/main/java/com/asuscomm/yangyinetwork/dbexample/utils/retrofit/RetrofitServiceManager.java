package com.asuscomm.yangyinetwork.dbexample.utils.retrofit;

import android.util.Log;


import com.asuscomm.yangyinetwork.dbexample.services.network.KtIotMakerNetwork;
import com.asuscomm.yangyinetwork.dbexample.utils.consts.URL;

import java.util.HashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */
public class RetrofitServiceManager {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static RetrofitServiceManager mInstance;

    private HashMap<Class, Object> services = new HashMap<>();

    public Object getService(Class type) {
        Object service = services.get(type);
        if (service == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(URL.urls.get(type.getName()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = client.create(type);
            services.put(type, service);
        }
        return service;
    }

    public static RetrofitServiceManager getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitServiceManager();
        }

        return mInstance;
    }
}
