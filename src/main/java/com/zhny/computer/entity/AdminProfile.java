package com.zhny.computer.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminProfile {
    private Integer id;
    private Integer amid;
    private String adminName;
    private String configData;
    private Long totalPrice;
    private Date createdTime;
}
