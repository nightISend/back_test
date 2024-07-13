package com.example.back.interfaces;

import com.example.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,String> {
    //根据用户名和密码判断用户是否存在
    @Query(value = "select * from user where username=?1 and password=?2",nativeQuery = true)
    User GetUser(String Username, String password);
}
