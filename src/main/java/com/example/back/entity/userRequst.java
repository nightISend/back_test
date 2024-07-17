package com.example.back.entity;

// /login的json请求体
public class userRequst {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    @Override
    public String toString() {
        return "userRequst{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
