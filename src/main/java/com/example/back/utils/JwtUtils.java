package com.example.back.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class JwtUtils {
    private static long expire=604800;
    private static String secret="登录用的token";
    private static String RefreshSecret="刷新用的token";

//    用于生成登录token
    public static String generateLoginToken(String Username){

        Date now=new Date();
//      7天后过期
        Date expiration=new Date(now.getTime()+1000*expire);
        HashMap<String, Object> map = new HashMap<>();
        return JWT.create()
                .withHeader(map)
                .withClaim("username",Username)//指定用什么内容生成Token，这里用用户名生成，可以继续.withClaim添加
                .withExpiresAt(expiration) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256(secret));//签名
    }

//    使用签名解析登录token
    public static String getUsernameFromLoginToken(String token){
        try {
            //设置密钥及算法
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();//f
            DecodedJWT jwt = verifier.verify(token);//g
            String Username = jwt.getClaims().get("username").asString();//h
            return Username;
        } catch (Exception e) {
            return "登录token解析错误";
        }
    }

//    用于生成刷新的token
    public static String generateRefreshToken(String Username){

        Date now=new Date();
    //      7天后过期
        Date expiration=new Date(now.getTime()+1000*expire);
        HashMap<String, Object> map = new HashMap<>();
        return JWT.create()
                .withHeader(map)
                .withClaim("username",Username)
                .withClaim("createTime",now.toString())
                .withExpiresAt(expiration) // 指定令牌的过期时间
                .sign(Algorithm.HMAC256(RefreshSecret));//签名
    }
    //    使用签名解析刷新token
    public static String getUsernameFromRefreshToken(String token){
        try {
            //设置密钥及算法
            Algorithm algorithm = Algorithm.HMAC256(RefreshSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String Username = jwt.getClaims().get("username").asString();
            return Username;
        } catch (Exception e) {
            return "刷新token解析错误";
        }
    }
}
