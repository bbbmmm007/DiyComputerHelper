package com.zhny.computer.entity;

import lombok.Data;

@Data
public class Knowledge extends BaseEntity{
    Integer knid;
    String topic;
    Integer ancestorId;
    String ancestorName;
    String content;
}
