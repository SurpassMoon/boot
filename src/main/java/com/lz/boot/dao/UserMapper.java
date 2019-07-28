package com.lz.boot.dao;

import com.lz.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

@Mapper
public interface UserMapper {

    User selectById(Serializable id);
}
