package com.lz.boot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/23 3:27 下午
 */
@Configuration
@MapperScan(value={"com.lz.boot.**.*mapper"})
public class MybatisPlusConfig {
}
