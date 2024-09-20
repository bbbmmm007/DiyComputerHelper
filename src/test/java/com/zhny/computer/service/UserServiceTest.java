package com.zhny.computer.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest //表示当前类是一个测试类
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;


}
