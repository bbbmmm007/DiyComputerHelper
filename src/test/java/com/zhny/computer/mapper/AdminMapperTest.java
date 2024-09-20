package com.zhny.computer.mapper;


import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest //表示当前类是一个测试类
@RunWith(SpringRunner.class)
public class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void delete() {
        adminMapper.deleteUser(8);
        System.out.println();
    }

    @Test
    public void insert() {
        Product product = new Product();

        product.setChildId(214);
        product.setItemType("4070 supper");

        product.setPrice(4999L);
        product.setStatus(1);

        product.setCreatedTime(new Date());
        product.setCreatedUser("bm");
        for (int i=0; i < 5; i++) {
            adminMapper.insertProduct(product);
            System.out.println(product);
        }
    }
    @Test
    public void selectUser(){

        System.out.println(adminMapper.getUserAgeGenderDistribution(0));
    }

    @Test
    public void updatePassword(){
        adminMapper.updatePasswordByAmid(2,"123","mm",new Date());
    }
    @Test
    public void reg(){
        Admin admin = new Admin();
        admin.setAdminName("dd");
        admin.setPassword("123");
        admin.setCreatedUser(admin.getAdminName());
        admin.setCreatedTime(new Date());
        adminMapper.insert(admin);
    }


}
