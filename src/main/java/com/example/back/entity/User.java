package com.example.back.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Date;

//数据库用户实体
@Entity
@Table(name="user")
public class User {

    private String avatar;
    @Id
    private String username;
    private String password;
    private String nickname;
    private List<String> roles;
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

    public void setExpires(Date expires) {
        this.expires = expires;
    }
    public Date getExpires() {
        return expires;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
