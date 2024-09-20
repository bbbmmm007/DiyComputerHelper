package com.zhny.computer.vo;

import com.zhny.computer.entity.Cart;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
/** 购物车数据的Value Object类 */
public class CartVO implements Serializable {
    private List<Cart> cartList;
    private double totalPrice;

}
