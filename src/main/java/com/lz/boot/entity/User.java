package com.lz.boot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class User {

    @NotNull(message = "主键不能为空。")
    private Long id;

    @NotBlank(message = "用户名不能为空。")
    private String username;

    @NotBlank(message = "用户名不能为空。")
    private String password;

    private Integer sex;

    private Integer age;




}