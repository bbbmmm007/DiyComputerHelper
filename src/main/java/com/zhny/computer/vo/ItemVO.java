package com.zhny.computer.vo;

import lombok.Data;

@Data
public class ItemVO {
    private Integer id;  //商品id
    private String ancestorName;  // 商品分类
    private String itemType;      // 商品名称
    private Long price;         // 商品价格
}
