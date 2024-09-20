package com.zhny.computer.service;

import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.vo.UserDistributionVO;

import java.util.List;


public interface AdminService {
    //管理员登录
    Admin login(String adminName, String password);
    //管理员注册
    void register(Admin admin);
    //管理员删除用户
    void deleteUser(Integer amid,Integer uid);
    //新增商品
    void insertProduct(Integer amid,String adminName,Product product);
    //更新商品信息
    void updateProduct(Integer amid, String adminName, Integer id, Product product);
    //删除商品
    void deleteProduct(Integer amid,Integer id);
    //注销管理员
    void deleteAdmin(Integer amid);
    //更改管理员密码
    void updateAdmin(Integer amid,String adminName,String oldPassword,String newPassword);
    //展示用户分布情况
    List<UserDistributionVO>  getUserAgeGenderDistribution(Integer amid);
    //展示所有用户
    List<User> selectUser(Integer amid);
}
