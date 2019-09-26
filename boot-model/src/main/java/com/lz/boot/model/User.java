package com.lz.boot.model;

import com.lz.boot.common.base.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/18 4:55 下午
 */
@Data
public class User extends BaseEntity {

    @NotNull(message = "姓名不能为空")
    private String name;
    @Length(min = 1, max = 200, message = "请输入正确年龄")
    private Integer age;
    private String email;

}
