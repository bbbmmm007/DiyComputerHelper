package com.zhny.computer.mapper;

import com.zhny.computer.entity.Cart;
import com.zhny.computer.vo.ProfileCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    //添加商品进入配置车
    Integer addProfileCart(Cart cart);
    //移除配置车中的商品
    Integer deleteProfileCart(@Param("uid") Integer uid,@Param("id") Integer id);
    //一键清空配置车中商品
    Integer clearProfileCart(Integer uid);
    //检查配置车中商品种类是否重复添加
    Integer checkAncestorInProfileCart(@Param("uid") Integer uid, @Param("ancestorId") Integer ancestorId);
    //展示配置车的商品
    List<Cart> showProfileCart(Integer uid);
    //生成配置单
    List<ProfileCartVO> getProfileCartItems(Integer uid);




}