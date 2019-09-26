package com.lz.boot;

import com.lz.boot.common.base.BaseEntity;
import lombok.Data;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/18 4:55 下午
 */
@Data
public class User extends BaseEntity {

    private String name;
    private Integer age;
    private String email;

}
