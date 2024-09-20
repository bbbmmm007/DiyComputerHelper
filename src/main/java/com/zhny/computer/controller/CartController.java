package com.zhny.computer.controller;

import com.zhny.computer.entity.Cart;
import com.zhny.computer.service.CartService;
import com.zhny.computer.service.util.JsonResult;
import com.zhny.computer.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private CartService cartService;

    //添加商品进入配置车的接口
    @RequestMapping("add_carts")
    public JsonResult<Void> addCarts(HttpSession session,Integer id,Cart cart) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.addProfileCart(uid,username,id,cart);
        return new JsonResult<Void>(SUCCESS);
    }
    //移除商品进入配置车的接口
    @RequestMapping("delete_carts")
    public JsonResult<Void> deleteCarts(HttpSession session,Integer id) {
        Integer uid = getUidFromSession(session);
        cartService.deleteProfileCart(uid,id);
        return new JsonResult<>(SUCCESS);
    }
    //清空配置车的接口
    @RequestMapping("clear_carts")
    public JsonResult<Void> clearCarts(HttpSession session) {
        Integer uid = getUidFromSession(session);
        cartService.clearProfileCart(uid);
        return new JsonResult<>(SUCCESS);
    }
    //展示配置车的接口
    @RequestMapping("show_carts")
    public JsonResult<CartVO> showCarts(HttpSession session) {
        Integer uid = getUidFromSession(session);
        CartVO carts = cartService.showProfileCart(uid);
        return new JsonResult<>(SUCCESS, carts);
    }

}
