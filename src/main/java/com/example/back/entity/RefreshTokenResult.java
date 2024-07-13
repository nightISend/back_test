package com.example.back.entity;

import java.util.Date;

//刷新token接口的返回数据类型
public class RefreshTokenResult {
    public class Data{
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

        @Override
        public String toString() {
            return "Data{" +
                    "accessToken='" + accessToken + '\'' +
                    ", refreshToken='" + refreshToken + '\'' +
                    ", expires=" + expires +
                    '}';
        }
    }

    public RefreshTokenResult(){
        this.data=new Data();
    }

    private boolean success;
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "RefreshTokenResult{" +
                "success=" + success +
                ", data=" + data.toString() +
                '}';
    }
}
