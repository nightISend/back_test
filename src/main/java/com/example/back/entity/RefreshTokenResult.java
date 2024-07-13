package com.example.back.entity;

import java.util.Date;

//刷新token接口的返回数据类型
public class RefreshTokenResult {
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    private String accessToken;
    private String refreshToken;
    private Date expires;
}
