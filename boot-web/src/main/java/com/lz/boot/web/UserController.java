package com.lz.boot.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lz.boot.model.User;
import com.lz.boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/18 5:21 下午
 */

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> get(){
        List<User> users = userService.list();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/pages")
    public ResponseEntity get(IPage<User> page){
        IPage<User> users = userService.page(page);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/users")
    public ResponseEntity post(@Validated User user){
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users")
    public ResponseEntity put(User user){
        userService.update();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Serializable id){
        userService.removeById(id);
        return ResponseEntity.ok().build();
    }

}
