package com.example.back.entity;

// /refresh-token的json请求体
public class refreshTokenRequest {
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    private String refreshToken;
}
