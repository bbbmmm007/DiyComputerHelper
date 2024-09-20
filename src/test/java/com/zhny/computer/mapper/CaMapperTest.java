package com.zhny.computer.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest //表示当前类是一个测试类
@RunWith(SpringRunner.class)
public class CaMapperTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void findAname(){

        System.out.println(categoryMapper.findAncestorNameByChid(211));


    }


}
