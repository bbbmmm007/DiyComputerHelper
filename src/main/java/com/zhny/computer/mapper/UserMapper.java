package com.zhny.computer.mapper;

import com.zhny.computer.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface UserMapper {
    //用户注册
    Integer insert(User user);
    //查询用户用户名是否重复
    User findByUsername(String username);
    //更新密码
    Integer updatePasswordByUid(@Param("uid") Integer uid,@Param("password") String password,@Param("modifiedUser") String modifiedUser,@Param("modifiedTime") Date modifiedTime);
    //根据uid查询用户信息
    User findByUid(Integer uid);
    //用户更新信息
    Integer updateInfoByUid(User user);//也可以用三个String的形参接收电话,邮箱,性别,但不如直接写个user省事
    //分页查询用户信息
    List<User> findUsersByPage( @Param("pageSize") Integer pageSize,@Param("offset") Integer offset);
    //统计用户数量
    Integer countUsers();
}

