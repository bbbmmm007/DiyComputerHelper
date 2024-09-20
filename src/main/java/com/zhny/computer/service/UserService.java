package com.zhny.computer.service;

import com.zhny.computer.entity.User;

import java.util.List;

public interface UserService {
    //注册接口
    void reg(User user);
    //登录接口
    User login(String username, String password);
    //更新密码接口
    void changePassword(Integer uid, String username,String oldPassword, String newPassword);
    //根据用户uid查询用户信息接口
    User getByUid(Integer uid);
    //用户更新信息接口
    void changeInfo(Integer uid,String username,User user);
    //分页查询用户
    List<User> findUsersByPage(Integer amid,Integer pageNumber, Integer pageSize);
    //统计用户数量
    Integer countUsers(Integer amid);

}
