package com.example.back.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.back.entity.User;
import com.example.back.entity.userRequst;

import java.util.Date;
import java.util.HashMap;

public class JwtUtils {
    //accessToken1小时后过期
    private static long expireAccess=30;
    //refreshToken2小时后过期
    private static long expireRefresh=60;
    private static String secret="登录用的token";
    private static String RefreshSecret="刷新用的token";

//    用于生成登录token
    public static String generateLoginToken(User user){

        Date now=new Date();
//      1小时后过期
        Date expiration=new Date(now.getTime()+1000*expireAccess);
        HashMap<String, Object> map = new HashMap<>();
        return JWT.create()
                .withHeader(map)
                .withClaim("username",user.getUsername())//指定用什么内容生成Token，这里用用户名生成，可以继续.withClaim添加
                .withClaim("password",user.getPassword())
                .withExpiresAt(expiration) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256(secret));//签名
    }

//    使用签名解析登录token
    public static userRequst getUsernameFromLoginToken(String token){
        try {
            //设置密钥及算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            userRequst result=new userRequst();
            result.setUsername(jwt.getClaims().get("username").asString());
            result.setPassword(jwt.getClaims().get("password").asString());

            return result;
        } catch (Exception e) {
            return new userRequst();
        }
    }

//    用于生成刷新的token
    public static String generateRefreshToken(User user){

        Date now=new Date();
    //  2小时后过期
        Date expiration=new Date(now.getTime()+1000*expireRefresh);
        HashMap<String, Object> map = new HashMap<>();
        return JWT.create()
                .withHeader(map)
                .withClaim("username",user.getUsername())
                .withClaim("createTime",now.toString())
                .withClaim("password",user.getPassword())
                .withExpiresAt(expiration) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256(RefreshSecret));//签名
    }
    //    使用签名解析刷新token
    public static userRequst getUsernameFromRefreshToken(String token){
        try {
            //设置密钥及算法
            Algorithm algorithm = Algorithm.HMAC256(RefreshSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            userRequst result=new userRequst();
            result.setUsername(jwt.getClaims().get("username").asString());
            result.setPassword(jwt.getClaims().get("password").asString());
            return result;
        } catch (Exception e) {
            return new userRequst();
        }
    }
}
