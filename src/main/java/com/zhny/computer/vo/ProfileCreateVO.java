package com.zhny.computer.vo;


import lombok.Data;

@Data
public class ProfileCreateVO {
    private String cpuType;   // CPU类型 (如: "IntelD4", "AmdD5")

    private Integer gpuType;          // 显卡类型 (如: "16a", "12n")
    private Integer gpuSize;          // 显存大小 (如: 8, 16)
    private Integer gpuModel;         //显卡型号 40系

    private Integer motherboardType;// 主板类型 (如: "D4IntelWiFi", "D5AmdNoWiFi")
    private Integer motherboardModel; //wifi还是无wifi  child
    private Integer  motherboardVersion;  //主板级别  parent

    private Integer memoryType;      // 内存类型 (如: "D4Memory", "D5Memory")
    private Integer memoryModel;  //内存颗粒
    private Integer memorySize;  //内存容量

    private Integer ssdType;  //固态类型
    private String ssdSize;         // 固态硬盘容量 (如: 512, 1024)


    private Integer coolingType;      // 散热类型 (如: "F", "W")
    private Integer coolingSize;    //散热规格

    private Integer supplySize;
    private Integer supplyType;  //电源类型
    private Integer supplyModel;  //电源型号


    private Integer caseType;  //机箱类型
    private Integer caseModel; //机箱型号

    private Integer totalBudget;//总价
}
