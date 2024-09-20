package com.zhny.computer.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Collection {
    Integer coid;
    Integer uid;
    Integer id;
    Integer childId;
    String itemType;
    Long price;
    String image;
    Date createdTime;
}
