package com.asuscomm.yangyinetwork.dbexample.services.network;

import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.RetrofitServiceManager;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class KtIotMakerNetwork {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static KtIotMakerNetwork mInstance;
    KtIotMakerService openApiService ;
    KtIotMakerAuthService authService;

    public KtIotMakerNetwork() {
        authService = (KtIotMakerAuthService) RetrofitServiceManager.getInstance().getService(KtIotMakerAuthService.class);
        openApiService = (KtIotMakerService) RetrofitServiceManager.getInstance().getService(KtIotMakerService.class);
    }

    public static KtIotMakerNetwork getInstance() {
        if (mInstance == null) {
            mInstance = new KtIotMakerNetwork();
        }

        return mInstance;
    }

    public void getToken() {
        Log.d(TAG, "getToken: ");
//        authService.getToken();
    }

    public void getStream() {

    }
}
