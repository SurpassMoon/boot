package com.lz.boot.service;

import com.lz.boot.dao.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description TODO
 * @author li zhe
 * @createTime 2019-08-22 10:59
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    DataSource dataSource;

//    @Autowired
//    SqlSessionFactoryBean sqlSessionFactoryBean;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public Object getUser() throws SQLException {

//        sqlSessionFactoryBean.getDatabaseIdProvider();

        System.out.println(sqlSessionFactory.getConfiguration().getDatabaseId());
        System.out.println(dataSource.getConnection().getMetaData().getDatabaseProductName());

        return userMapper.selectById(1);

    }

}
