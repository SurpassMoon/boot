package com.lz.boot.service;

import com.lz.boot.dao.UserMapper;
import com.lz.boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

//    @DS("slave_1")
    public User selectById(int i) {
        return userMapper.selectById(i);
    }
}
