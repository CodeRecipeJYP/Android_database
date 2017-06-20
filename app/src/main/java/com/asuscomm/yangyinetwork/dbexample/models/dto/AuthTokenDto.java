package com.asuscomm.yangyinetwork.dbexample.models.dto;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class AuthTokenDto {
    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
    private String svc_tgt_seq;
    private String unit_svc_cd;
    private long pub_time;
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

    @Override
    public String toString() {
        return "AuthTokenDto{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", scope='" + scope + '\'' +
                ", svc_tgt_seq='" + svc_tgt_seq + '\'' +
                ", unit_svc_cd='" + unit_svc_cd + '\'' +
                ", pub_time=" + pub_time +
                ", mbr_id='" + mbr_id + '\'' +
                ", dstr_cd='" + dstr_cd + '\'' +
                ", mbr_seq='" + mbr_seq + '\'' +
                ", mbr_clas='" + mbr_clas + '\'' +
                ", company='" + company + '\'' +
                ", mbr_nm='" + mbr_nm + '\'' +
                ", platform='" + platform + '\'' +
                ", theme_cd='" + theme_cd + '\'' +
                ", jti='" + jti + '\'' +
                '}';
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
}
