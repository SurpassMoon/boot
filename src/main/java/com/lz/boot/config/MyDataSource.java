package com.lz.boot.config;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDataSource {

    String value() default "datasource1";

}