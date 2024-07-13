package com.example.back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static com.example.back.utils.JwtUtils.*;


@SpringBootTest
class BackApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	//token的生成和解算以实现
	public void jwtApiTest(){
		String accessToken=generateLoginToken("燦");
		System.out.println("这是accessToken:"+accessToken);
		String refreshToken=generateRefreshToken("燦");
		System.out.println("这是refreshToken:"+refreshToken);

		String Username=getUsernameFromLoginToken(refreshToken);
		System.out.println("这是从accessToken里取出的用户名:"+Username);
		System.out.println("这是从refreshToken里取出的用户名:"+getUsernameFromRefreshToken(refreshToken));

	}

}
