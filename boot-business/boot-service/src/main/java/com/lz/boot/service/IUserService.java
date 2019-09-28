package com.lz.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.boot.model.User;

import java.util.List;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/18 5:29 下午
 */
public interface IUserService extends IService<User> {

    List<User> listWrapper(User user);
}
