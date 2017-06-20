package com.asuscomm.yangyinetwork.dbexample.models.dto;

/**
 * Created by jaeyoung on 2017. 6. 19..
 */

public class UserLogInfo {
    private String username;
    private String passwrod;
    private String grant_type;

    public UserLogInfo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}