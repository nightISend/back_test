package com.example.back;

import com.example.back.entity.User;
import com.example.back.entity.UserResult;
import com.example.back.interfaces.userRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

	//user数据库连接读取成功
	@Autowired
	private userRepository UserRepository;
	@Test
	public void DBTest(){
		User user=UserRepository.GetUser("admin","admin123");
		System.out.println(user.toString());
	}

	//UserResult测试
	@Test
	public void UserResultTest(){
		User user=UserRepository.GetUser("admin","admin123");
		UserResult result=new UserResult(user);
		System.out.println(result.toString());
	}
}
