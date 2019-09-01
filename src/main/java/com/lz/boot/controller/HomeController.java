package com.lz.boot.controller;


import com.lz.boot.dao.UserMapper;
import com.lz.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;



    @GetMapping("/")
    public void home() throws SQLException {
//        userMapper.selectById(1);
        userService.getUser();
        System.out.println("欢迎");
    }

}
