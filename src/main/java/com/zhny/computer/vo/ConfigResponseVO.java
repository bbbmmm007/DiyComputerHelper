package com.zhny.computer.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ConfigResponseVO {
    private List<ItemVO> items; // 配置的具体内容
    private Long totalPrice; // 总价格
    private Date createdTime;
}
