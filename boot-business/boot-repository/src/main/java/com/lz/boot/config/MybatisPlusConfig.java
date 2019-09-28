package com.lz.boot.config;

import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/23 3:27 下午
 */
@Configuration
@MapperScan(value = {"com.lz.boot.**.*mapper"})
public class MybatisPlusConfig {

    /**
     * sequence主键，需要配置一个主键生成器
     * 配合实体类注解 {@link KeySequence} + {@link TableId} type=INPUT
     * @return
     */
    @Bean
    public H2KeyGenerator h2KeyGenerator(){
        return new H2KeyGenerator();
    }


}
