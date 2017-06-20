package com.asuscomm.yangyinetwork.dbexample.services.network;

import android.util.Base64;
import android.util.Log;

import com.asuscomm.yangyinetwork.dbexample.models.dto.AuthTokenDto;
import com.asuscomm.yangyinetwork.dbexample.models.dto.DeviceDto;
import com.asuscomm.yangyinetwork.dbexample.models.dto.StreamDto;
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

    String authorization;

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
                Log.d(TAG, "onResponse: getToken Code="+response.code()+" message="+response.message());
                if(response.isSuccessful()) {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<AuthTokenDto> call, Throwable t) {
                Log.e(TAG, "onFailure: getToken "+t.toString());
            }
        });
    }

    public void getDevices(final OnSuccessListener listener) {
        Log.d(TAG, "getDevices: ");
        getAuthorization(new OnSuccessListener() {
            @Override
            public void onSuccess(Object result) {
                Log.d(TAG, "onSuccess: result="+result);
                Call<DeviceDto> call = openApiService.getDevices(0, 10, (String) result);
                call.enqueue(new Callback<DeviceDto>() {
                    @Override
                    public void onResponse(Call<DeviceDto> call, Response<DeviceDto> response) {
                        Log.d(TAG, "onResponse: getDevices Code=" + response.code() + " message=" + response.message());
                        if (response.isSuccessful()) {
                            listener.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<DeviceDto> call, Throwable t) {
                        Log.e(TAG, "onFailure: getDevices " + t.toString());
                    }
                });
            }
        });
    }

    public void getStream(final String deviceId, final OnSuccessListener listener) {
        getAuthorization(new OnSuccessListener() {
            @Override
            public void onSuccess(Object result) {
                Call<StreamDto> call = openApiService.getStreamData(deviceId, 99999, (String) result);
                call.enqueue(new Callback<StreamDto>() {
                    @Override
                    public void onResponse(Call<StreamDto> call, Response<StreamDto> response) {
                        Log.d(TAG, "onResponse: getStream Code=" + response.code() + " message=" + response.message());
                        if (response.isSuccessful()) {
                            listener.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<StreamDto> call, Throwable t) {
                        Log.e(TAG, "onFailure: getStream " + t.toString());
                    }
                });
            }
        });
    }

    private void getAuthorization(final OnSuccessListener listener) {
        if (authorization == null) {
            getToken(new OnSuccessListener() {
                @Override
                public void onSuccess(Object result) {
                    AuthTokenDto auth = (AuthTokenDto)result;
                    authorization = auth.getToken_type() + " " + auth.getAccess_token();
                    listener.onSuccess(authorization);
                }
            });
        } else {
            listener.onSuccess(authorization);
        }
    }
}
