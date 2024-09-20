package com.zhny.computer.service;

import com.zhny.computer.entity.Cart;
import com.zhny.computer.vo.CartVO;
import com.zhny.computer.vo.ProfileCartVO;

import java.util.List;

public interface CartService {
    //添加商品进入配置车
    void addProfileCart(Integer uid, String username, Integer id,Cart cart);
    //移除配置车中的商品
    void deleteProfileCart(Integer uid,Integer id);
    //清空配置车商品
    void clearProfileCart(Integer uid);
    //展示配置车中商品
    CartVO showProfileCart(Integer uid);
    //生成配置单
    List<ProfileCartVO> showProfileCartVO(Integer uid);
}



