package com.asuscomm.yangyinetwork.dbexample.models.dto;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class AuthTokenDto {
    private String access_token;
    private int expires_in;
    private String scope;
    private String svc_tgt_seq;
    private String unit_svc_cd;
    private int pub_time;
    private String mbr_id;
    private String dstr_cd;
    private String mbr_seq;
    private String mbr_clas;
    private String company;
    private String mbr_nm;
    private String platform;
    private String theme_cd;
    private String jti;

    public AuthTokenDto() {
    }
}
