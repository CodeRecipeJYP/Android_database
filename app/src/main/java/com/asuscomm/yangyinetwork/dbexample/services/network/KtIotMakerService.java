package com.asuscomm.yangyinetwork.dbexample.services.network;

import com.asuscomm.yangyinetwork.dbexample.models.dto.SensorDataDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public interface KtIotMakerService {
    @GET("api/v1/streams/{device_id}/log")
    Call<SensorDataDto> getStreamData(
            @Path("device_id") String deviceId,
            @Query("period") int period,
            @Header("Authorization") String authorization);
}

