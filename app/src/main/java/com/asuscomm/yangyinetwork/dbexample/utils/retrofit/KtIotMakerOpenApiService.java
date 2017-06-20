package com.asuscomm.yangyinetwork.dbexample.utils.retrofit;

import com.asuscomm.yangyinetwork.dbexample.models.dto.DeviceDto;
import com.asuscomm.yangyinetwork.dbexample.models.dto.StreamDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public interface KtIotMakerOpenApiService {
    @GET("api/v1/streams/{device_id}/log")
    Call<StreamDto> getStreamData(
            @Path("device_id") String deviceId,
            @Query("period") int period,
            @Header("Authorization") String authorization);

    @GET("api/v1.1/devices")
    Call<DeviceDto> getDevices(
            @Query("offset") int offset,
            @Query("limit") int limit,
            @Header("Authorization") String authorization);
}

