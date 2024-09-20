package com.zhny.computer.service;

import com.zhny.computer.entity.Cart;
import com.zhny.computer.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartServiceTest {
    @Autowired
    private CartService cartService;
    private Product product;
    @Test
    public void testAddProduct() {
        Cart cart = new Cart();
        cartService.addProfileCart(328,"bm",100000481,cart);
    }
    @Test
    public void delProduct() {
        cartService.deleteProfileCart(328,100000468);
    }
    @Test
    public void showCarts(){
        cartService.showProfileCart(328);
    }
    @Test
    public void clreaCart(){
        cartService.clearProfileCart(328);
    }

}
