package com.example.back.entity;

import java.util.Arrays;
import java.util.Date;

// /login的返回体
public class userResult {
    public class Data {

        public Data(User user){
            this.username=user.getUsername();
            this.avatar=user.getAvatar();
            this.expires=user.getExpires();
            this.nickname=user.getNickname();
            //user的role按","分割并形成数组
            this.roles=user.getRoles().split(",");

        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public Date getExpires() {
            return expires;
        }

        public void setExpires(Date expires) {
            this.expires = expires;
        }

        private String avatar;
        private String username;
        private String nickname;
        private String[] roles;
        private String accessToken;
        private String refreshToken;
        private Date expires;

        @Override
        public String toString() {
            return "Data{" +
                    "avatar='" + avatar + '\'' +
                    ", username='" + username + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", roles=" + Arrays.toString(roles) +
                    ", accessToken='" + accessToken + '\'' +
                    ", refreshToken='" + refreshToken + '\'' +
                    ", expires=" + expires +
                    '}';
        }
    }

    private boolean success;
    private String condition;
    private Data data;

    public userResult(User user){
        Data data=new Data(user);
        setData(data);
    }
    public userResult(){
        this.data=null;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }
    public void setCondition(String condition) {
        this.condition = condition;
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

    @Override
    public String toString() {
        return "UserResult{" +
                "success=" + success +
                ", condition='" + condition + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
