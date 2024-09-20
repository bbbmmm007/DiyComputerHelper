package com.zhny.computer.entity;


import lombok.Data;

@Data
public class Category {
    private Integer caid;
    private Integer ancestorId;
    private String ancestorName;
    private Integer parentId;
    private String parentName;
    private Integer childId;
    private String childName;
}
