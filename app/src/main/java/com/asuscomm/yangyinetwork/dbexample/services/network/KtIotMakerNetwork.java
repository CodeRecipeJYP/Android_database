package com.asuscomm.yangyinetwork.dbexample.services.network;

import android.util.Base64;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.dto.AuthTokenDto;
import com.asuscomm.yangyinetwork.dbexample.utils.consts.SECRET;
import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.KtIotMakerAuthService;
import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.KtIotMakerOpenApiService;
import com.asuscomm.yangyinetwork.dbexample.utils.retrofit.RetrofitServiceManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class KtIotMakerNetwork {
    public interface OnSuccessListener {
        void onSuccess(Object result);
    }
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static KtIotMakerNetwork mInstance;
    KtIotMakerOpenApiService openApiService ;
    KtIotMakerAuthService authService;

    public KtIotMakerNetwork() {
        authService = (KtIotMakerAuthService) RetrofitServiceManager.getInstance().getService(KtIotMakerAuthService.class);
        openApiService = (KtIotMakerOpenApiService) RetrofitServiceManager.getInstance().getService(KtIotMakerOpenApiService.class);
    }

    public static KtIotMakerNetwork getInstance() {
        if (mInstance == null) {
            mInstance = new KtIotMakerNetwork();
        }

        return mInstance;
    }

    public void getToken(final OnSuccessListener listener) {
        Log.d(TAG, "getToken: ");
        String basicAuth = SECRET.APP_ID+":"+SECRET.APP_SECRET;
        String authorization = "Basic "+ Base64.encodeToString(basicAuth.getBytes(), 0);
        authorization = authorization.substring(0, authorization.length()-1);
        Call<AuthTokenDto> call = authService.getToken(SECRET.IOTMAKER_USERNAME,
                                                        SECRET.IOTMAKER_PASSWORD,
                                                        "password",
                                                        authorization);
        call.enqueue(new Callback<AuthTokenDto>() {
            @Override
            public void onResponse(Call<AuthTokenDto> call, Response<AuthTokenDto> response) {
                Log.d(TAG, "onResponse: Code="+response.code()+" message="+response.message());
                if(response.isSuccessful()) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<AuthTokenDto> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString());
            }
        });
    }

    public void getStream() {

    }
}
