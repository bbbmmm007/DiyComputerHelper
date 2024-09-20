package com.zhny.computer.entity;

import lombok.Data;

@Data
/**购物车数据的实体类*/
public class Cart extends BaseEntity {
    private Integer cid;
    private Integer uid;
    private Integer id;
    private Integer childId;
    private Integer ancestorId;
    private String ancestorName;
    private Long price;
    private String itemType;
    private String image;
}
