package com.lz.boot.dao;

import com.lz.boot.configT.MyDataSource;
import com.lz.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

@Mapper
public interface UserMapper {

//    @DataSource("slave1")
    @MyDataSource()
    User selectById(Serializable id);
}
