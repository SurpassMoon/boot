package com.lz.boot.controller;


import com.lz.boot.entity.User;
import com.lz.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    @ResponseBody
    public User home(){

        return userService.selectByid();
    }

}
