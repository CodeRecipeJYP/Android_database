package com.asuscomm.yangyinetwork.dbexample.services.network;

import com.asuscomm.yangyinetwork.dbexample.models.dto.AuthTokenDto;
import com.asuscomm.yangyinetwork.dbexample.models.dto.UserLogInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public interface KtIotMakerAuthService {
    @POST("oauth/token")
    Call<AuthTokenDto> getToken(
        @Body UserLogInfo userLogInfo,
        @Header("Authorization") String authorization
        );
}
