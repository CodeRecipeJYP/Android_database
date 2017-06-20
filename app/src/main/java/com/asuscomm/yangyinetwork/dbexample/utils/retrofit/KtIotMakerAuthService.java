package com.asuscomm.yangyinetwork.dbexample.utils.retrofit;

import com.asuscomm.yangyinetwork.dbexample.models.dto.AuthTokenDto;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public interface KtIotMakerAuthService {
    @FormUrlEncoded
    @POST("oauth/token")
    Call<AuthTokenDto> getToken(
        @Field("username") String username,
        @Field("password") String password,
        @Field("grant_type") String grant_type,
        @Header("Authorization") String authorization
        );
}
