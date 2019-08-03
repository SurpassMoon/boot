package com.lz.boot.annotation;

import com.lz.boot.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * @ClassName Ds.java
 * @Description 数据源注解
 * @author li zhe
 * @createTime 2019-08-03 10:06
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Ds {

    DataSourceType value() default DataSourceType.MASTER;

}