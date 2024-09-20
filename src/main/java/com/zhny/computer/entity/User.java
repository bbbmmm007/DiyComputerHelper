package com.zhny.computer.entity;

import lombok.Data;

import java.io.Serializable;
@Data

public class User extends BaseEntity implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private Integer gender;
    private Integer age;
    private String avatar;
    private Integer isDelete;

}
