package com.zhny.computer.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest //表示当前类是一个测试类
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Test
    public void insert() {
        collectionMapper.checkCollection(100000468,314);
        System.out.println(collectionMapper.checkCollection(100000468,341));
    }
    @Test
    public void show(){

        System.out.println(userMapper.findUsersByPage(5,0));
    }
    @Test
    public void findUsersByPage(){
        userMapper.countUsers();
        System.out.println(userMapper.countUsers());
    }

}
