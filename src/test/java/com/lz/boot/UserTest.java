package com.lz.boot;

import com.lz.boot.dao.UserMapper;
import com.lz.boot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void test() throws SQLException {


//        User user = userMapper.selectById("1");


        System.out.println(userService.getUser());

    }


}
