package com.zhny.computer.entity;

import lombok.Data;

import java.util.Date;
@Data
public class UserProfile {
    private Integer id;
    private Integer uid;
    private String username;
    private String configData;
    private Long totalPrice;
    private Date createdTime;
}
