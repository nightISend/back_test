package com.example.back.controller;

import com.example.back.entity.User;
import com.example.back.entity.UserResult;
import com.example.back.interfaces.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.back.utils.JwtUtils.generateLoginToken;
import static com.example.back.utils.JwtUtils.generateRefreshToken;

//首次登录
@RestController
public class login {
    @Autowired
    private userRepository UserRepository;

    @PostMapping("/login")
    public UserResult loginFirst(String username, String password){
        UserResult result=new UserResult();
        User user=UserRepository.isUserExist(username,password);
        if (user==null){
            result.setSuccess(false);
            result.setCondition("用户名或密码错误");
        }
        else{
            result.setSuccess(true);
            result.setCondition("用户存在");
//            result.getData().setUsername(username);
//            result.getData().setNickname(user.getNickname());
//            result.getData().setRoles(user.getRoles());
//            result.getData().setAvatar(user.getAvatar());
//            result.getData().setExpires(user.getExpires());
//            result.getData().setAccessToken(generateLoginToken(username));
//            result.getData().setRefreshToken(generateRefreshToken(username));
        }
        return result;
    }

    @PostMapping("/test")
    public UserResult testReturnResult(){
        UserResult result=new UserResult();
        result.setSuccess(true);
        result.setCondition("用户存在");
        result.getData().setUsername("username");
        result.getData().setNickname("name");
        result.getData().setAvatar("http");
        result.getData().setAccessToken("access");
        result.getData().setRefreshToken("refresh");
        return result;
    }
}
