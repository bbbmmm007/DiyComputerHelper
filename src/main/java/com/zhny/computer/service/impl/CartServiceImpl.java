package com.zhny.computer.service.impl;

import com.zhny.computer.entity.Cart;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.mapper.CartMapper;
import com.zhny.computer.mapper.CategoryMapper;
import com.zhny.computer.mapper.ProductMapper;
import com.zhny.computer.mapper.UserMapper;
import com.zhny.computer.service.CartService;
import com.zhny.computer.service.ex.*;
import com.zhny.computer.vo.CartVO;
import com.zhny.computer.vo.ProfileCartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;


    //添加商品进入配置车的实现
    @Override
    public void addProfileCart(Integer uid, String username, Integer id, Cart cart) {
        User resultUser = userMapper.findByUid(uid);
        if (resultUser == null) {
            throw new UserNotFoundException("用户信息不存在");
        }
        Product resultProduct = productMapper.findById(id);
        if (resultProduct == null) {
            throw new ProductNotFoundException("商品信息不存在");
        }


        Integer resultCart = cartMapper.checkAncestorInProfileCart(uid,resultProduct.getAncestorId());
        System.out.println(resultCart);
        if (resultCart >=1 ) {
            throw new InsertException("该类商品已经加入购物车不要重复添加");
        }

        //补全插入信息
        cart.setUid(uid);
        cart.setId(id);
        cart.setChildId(resultProduct.getChildId());
        cart.setPrice(resultProduct.getPrice());
        cart.setImage(resultProduct.getImage());
        cart.setAncestorId(resultProduct.getAncestorId());
        cart.setItemType(resultProduct.getItemType());
        cart.setAncestorName(categoryMapper.findAncestorNameByChid(resultProduct.getChildId()));

        //补全日志
        cart.setCreatedUser(username);
        cart.setCreatedTime(new Date());
        cart.setModifiedTime(new Date());
        cart.setModifiedUser(username);



        Integer rows = cartMapper.addProfileCart(cart);
        if (rows != 1) {
            throw new InsertException("插入数据时发生未知错误");
        }

    }

    //移除商品配置车的实现
    @Override
    public void deleteProfileCart(Integer uid, Integer id) {
        User resultUser = userMapper.findByUid(uid);
        if (resultUser == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        Product resultProduct = productMapper.findById(id);
        if (resultProduct == null) {
            throw new ProductNotFoundException("产品不存在");
        }
        Integer rows = cartMapper.deleteProfileCart(uid,id);
        if (rows != 1) {
            throw new DeleteException("删除数据失败");
        }
    }

    //清空配置车的实现
    @Override
    public void clearProfileCart(Integer uid) {
        User resultUser = userMapper.findByUid(uid);
        if (resultUser == null) {
            throw new AccessDeniedException("非法的数据访问");
        }
        cartMapper.clearProfileCart(uid);
    }


    //展示所有商品的实现
    @Override
    public CartVO showProfileCart(Integer uid) {
        List<Cart> cartList = cartMapper.showProfileCart(uid);
        double totalPrice = 0.0;

        for (Cart cart : cartList) {
            totalPrice += cart.getPrice();
        }

        CartVO cartVO = new CartVO();
        cartVO.setCartList(cartList);
        cartVO.setTotalPrice(totalPrice);

        return cartVO;
    }
    //展示配置车中的数据
    @Override
    public List<ProfileCartVO> showProfileCartVO(Integer uid) {
        return cartMapper.getProfileCartItems(uid);
    }


}