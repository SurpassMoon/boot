package com.lz.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lz.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    
}
