package com.zhny.computer.entity;

import lombok.Data;

@Data
public class Profile extends BaseEntity{
    private Integer itid;
    private Integer uid;
    private String ancestorName;
    private String itemType;
    private Long price;
}
