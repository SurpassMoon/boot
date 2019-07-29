package com.lz.boot.controller;


import com.lz.boot.dao.UserMapper;
import com.lz.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public void home(){
        userService.selectById(1);
//        userMapper.selectById(1);
        System.out.println("欢迎");
    }

}
