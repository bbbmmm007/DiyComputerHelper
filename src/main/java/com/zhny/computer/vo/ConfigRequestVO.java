package com.zhny.computer.vo;

import lombok.Data;

import java.util.List;

@Data
public class ConfigRequestVO {
    private Integer uid; // 用户 ID
    private List<ItemVO> items; // 配置的具体内容
    private Long totalPrice; // 总价格
}
