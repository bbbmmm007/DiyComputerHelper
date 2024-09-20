package com.zhny.computer.entity;


import lombok.Data;

@Data
public class Admin extends BaseEntity{
    private Integer amid;
    private String adminName;
    private String password;

}
