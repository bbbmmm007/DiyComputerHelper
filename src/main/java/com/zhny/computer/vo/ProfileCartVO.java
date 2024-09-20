package com.zhny.computer.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProfileCartVO implements Serializable {
    private String ancestorName;
    private String itemType;
    private Long price;
}