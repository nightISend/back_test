package com.example.back.controller;

import com.example.back.entity.RefreshTokenResult;
import com.example.back.entity.User;
import com.example.back.entity.UserResult;
import com.example.back.interfaces.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.back.utils.JwtUtils.generateLoginToken;
import static com.example.back.utils.JwtUtils.generateRefreshToken;


@RestController
public class login {
    @Autowired
    private userRepository UserRepository;

    //首次登录
    @PostMapping("/login")
    public UserResult loginFirst(String username, String password){
        User user=UserRepository.GetUser(username,password);
        if(user==null){
            UserResult result=new UserResult();
            result.setSuccess(false);
            result.setCondition("用户名或密码错误");
            return result;
        }
        else {
            UserResult result=new UserResult(user);
            result.setSuccess(true);
            result.setCondition("用户存在");
            result.getData().setAccessToken(generateLoginToken(username));
            result.getData().setRefreshToken(generateRefreshToken(username));
            return result;
        }

    }

    //获取新token
    @PostMapping("/refresh-token")
    public RefreshTokenResult testReturnResult(String username, String password){
        RefreshTokenResult result=new RefreshTokenResult();
        User user=UserRepository.GetUser(username,password);
        if(user==null){
            result.setSuccess(false);
        }
        else{
            result.setSuccess(true);
            result.getData().setExpires(user.getExpires());
            result.getData().setRefreshToken(generateRefreshToken(username));
            result.getData().setAccessToken(generateLoginToken(username));
        }

        return result;

    }
}
