package com.lz.boot.controller;


import com.lz.boot.dao.UserMapper;
import com.lz.boot.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * UserController
 *
 * @author lizhe
 * @date 2016/10/31
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("users")
    public Object get() {
        log.info("测试控制层");
        List<User> users = userMapper.selectList(null);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("users")
    public ResponseEntity post(@RequestBody @Validated User user) {
        userMapper.insert(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("users")
    public ResponseEntity put(User user) {
        userMapper.updateById(user);
        return ResponseEntity.ok().body("成功");
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity delete(@PathParam("id") Serializable id) {
        userMapper.deleteById(id);
        return ResponseEntity.ok().body("成功");
    }


}
