package com.lz.boot.configT;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDataSource {

    String value() default "datasource1";

}