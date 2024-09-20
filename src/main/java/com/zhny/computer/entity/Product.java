package com.zhny.computer.entity;

import lombok.Data;

@Data
/** 商品数据的实体类 */
public class Product extends BaseEntity {
    private Integer id;
    private Integer childId;
    private Integer parentId;
    private Integer ancestorId;
    private String itemType;
    private Long price;
    private String image;
    private Integer status;
    private Integer salt;
    private Integer performanceScore;


//临时属性
    private String memorySupport;
    private Long minPrice;
    private String anid;
}