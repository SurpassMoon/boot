package com.lz.boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.boot.mapper.UserMapper;
import com.lz.boot.model.User;
import com.lz.boot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/23 2:55 下午
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Override
    public List<User> listWrapper(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(user.getName())){
            queryWrapper.like("name", user.getName());
        }
        if (user.getAge() != null) {
            queryWrapper.eq("age", user.getAge());
        }
        return super.list(queryWrapper);
    }
}
