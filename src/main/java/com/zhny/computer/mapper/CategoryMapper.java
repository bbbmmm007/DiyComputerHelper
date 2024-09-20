package com.zhny.computer.mapper;

public interface CategoryMapper {
    //根据子类id查询祖类名称
    String findAncestorNameByChid(Integer childId);


}
