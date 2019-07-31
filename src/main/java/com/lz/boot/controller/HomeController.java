package com.lz.boot.controller;


import com.lz.boot.dao.UserMapper;
import com.lz.boot.entity.User;
import com.lz.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HomeController {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    DataSource dataSource;

    @GetMapping("/")
    @ResponseBody
    public User home() throws Exception {
        dataSource.getConnection().getMetaData().getDatabaseProductName();
//        userMapper.selectById(1)
        userService.updata();
        return userService.selectByid();
    }

}
