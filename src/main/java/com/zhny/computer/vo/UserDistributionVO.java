package com.zhny.computer.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDistributionVO implements Serializable {
    private String ageRange;
    private String gender;
    private Integer count;
}
