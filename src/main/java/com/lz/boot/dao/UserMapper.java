package com.lz.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @DS("slave_1")
    @Override
    User selectById(Serializable id);
}
