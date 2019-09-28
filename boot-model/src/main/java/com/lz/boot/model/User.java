package com.lz.boot.model;

import com.lz.boot.common.base.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/18 4:55 下午
 */
@Data
@ToString(callSuper = true)
public class User extends BaseEntity {

    @NotEmpty(message = "姓名不能为空")
    private String name;
    private Integer age;
    private String email;

}
