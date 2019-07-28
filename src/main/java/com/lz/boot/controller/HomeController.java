package com.lz.boot.controller;


import com.lz.boot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public void home(){
        userMapper.selectById(1);
        System.out.println("欢迎");
    }

}
