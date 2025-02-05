package com.example.back;

import com.example.back.entity.Record12345Entity;
import com.example.back.entity.User;
import com.example.back.entity.englishWord.word;
import com.example.back.entity.userResult;
import com.example.back.interfaces.englishWordRepository;
import com.example.back.interfaces.userRepository;
import com.example.back.mapper.Record12345Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.back.utils.JwtUtils.*;


@SpringBootTest
class BackApplicationTests {

	@Test
	void contextLoads() {
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
		userResult result=new userResult(user);
		System.out.println(result.toString());
	}

	@Test
	//token的生成和解算以实现
	public void jwtApiTest(){
		User user=UserRepository.GetUser("202118100313","Lvu123123");
		String refreshToken=generateRefreshToken(user);
		System.out.println(refreshToken);
		System.out.println(getUsernameFromRefreshToken(refreshToken).toString());
	}


	@Autowired
	private englishWordRepository EnglishWordRepository;
	@Test
	//测试获取英语单词数据成功
	public void englishWordTest(){
	Pageable page= PageRequest.of(0, 14);
	List<word> result=EnglishWordRepository.getWordBySelect("","",2,2,page);
//	List<word> result=EnglishWordRepository.getWordByTranslation("补充",page);
		if(result.isEmpty()){
			System.out.println("空");
		}else {
			System.out.println(result.getFirst().toString());
		}

	}

//	测mybatis
	@Autowired
	private Record12345Mapper record12345Mapper;
	@Test
	void selectById() throws ParseException {
//		System.out.println(record12345Mapper.getAll());
		Record12345Entity record12345Entity =new Record12345Entity();
//		record12345Entity.setId("市本级-000236bae02d4c5c8a59b27aeb39f05f");
//		record12345Entity.setId("");
//		record12345Entity.setName("章先生");
//		record12345Entity.setAddress("海宁市盐官");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date occur_time = simpleDateFormat.parse("2023-08-14 05:41:27");
		java.sql.Date sqlDate=new java.sql.Date(occur_time.getTime());
		record12345Entity.setOccur_time(sqlDate);
		System.out.println(record12345Mapper.selectByConditions(record12345Entity));
	}
}
