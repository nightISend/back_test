package com.example.back.entity;

import java.util.List;
import java.util.Date;

//登录接口的返回数据类型
public class UserResult {
    public class Data {

        private String avatar;
        private String username;
        private String nickname;
        private List<String> roles;
        private String accessToken;
        private String refreshToken;
        private Date expires;
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        public String getAvatar() {
            return avatar;
        }

        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
        public String getNickname() {
            return nickname;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
        public List<String> getRoles() {
            return roles;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
        public String getAccessToken() {
            return accessToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }
        public String getRefreshToken() {
            return refreshToken;
        }

        public void setExpires(Date expires) {
            this.expires = expires;
        }
        public Date getExpires() {
            return expires;
        }

    }

    private boolean success;
    private String condition;
    private Data data;
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
