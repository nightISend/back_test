package com.example.back.controller;

import com.example.back.entity.*;
import com.example.back.interfaces.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.back.utils.JwtUtils.*;


@RestController
public class login {

    @Autowired
    private userRepository UserRepository;

    //首次登录
    @PostMapping("/login")
    //使用post传json需要先写一个类作为参数，注意类写在外面引入，同时一定要加@RequestBody
    public userResult loginFirst(@RequestBody userRequst UG){
        User user=UserRepository.GetUser(UG.getUsername(),UG.getPassword());
        if(user==null){
            userResult result=new userResult();
            result.setSuccess(false);
            result.setCondition("用户名或密码错误");
            return result;
        }
        else {
            userResult result=new userResult(user);
            result.setSuccess(true);
            result.setCondition("用户存在");
            result.getData().setAccessToken(generateLoginToken(user));
            result.getData().setRefreshToken(generateRefreshToken(user));
            return result;
        }

    }

    //获取新token，要给前端只是发回一个jwt
    @PostMapping("/refresh-token")
    public refreshTokenResult testReturnResult(@RequestBody refreshTokenRequest request){
        refreshTokenResult result=new refreshTokenResult();
        userRequst jwtInfo=getUsernameFromRefreshToken(request.getRefreshToken());
        User user=UserRepository.GetUser(jwtInfo.getUsername(),jwtInfo.getPassword());
        if (user==null){
            result.setSuccess(false);
        }
        else {
            result.setSuccess(true);
            result.getData().setAccessToken(generateLoginToken(user));
            result.getData().setRefreshToken(generateRefreshToken(user));
            result.getData().setExpires(user.getExpires());
        }
        return result;

    }
}
