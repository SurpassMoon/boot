package com.lz.boot;

import com.lz.boot.dao.UserMapper;
import com.lz.boot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){

        User user = userMapper.selectById("1");

        System.out.println(user);

    }

    public static void main(String[] args) {
        System.out.println(1%4);
    }


}
