package com.zhny.computer.mapper;


import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.vo.UserDistributionVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminMapper {
    //删除用户
    Integer deleteUser(Integer uid);
    //管理员注册
    Integer insert(Admin admin);
    //管理员更改密码
    Integer updatePasswordByAmid(@Param("amid") Integer amid,
                                @Param("password") String password,
                                @Param("modifiedUser") String modifiedUser,
                                @Param("modifiedTime") Date modifiedTime);
    //添加商品
    Integer insertProduct(Product product);
    //更新商品信息
    Integer updateProduct(
                          @Param("itemType") String itemType,
                          @Param("price") Long price,
                          @Param("image") String image,
                          @Param("salt") Integer salt,
                          @Param("performanceScore") Integer performanceScore,
                          @Param("modifiedUser") String modifiedUser,
                          @Param("modifiedTime") Date modifiedTime,
                          @Param("id") Integer id);
    //注销管理员账号
    Integer deleteAdmin(Integer amid);
    //通过管理员账号名查询信息
    Admin findByname(String adminName);
    //通过管理员id查询信息
    Admin findByAmid(Integer amid);
    //删除商品
    Integer deleteProduct(Integer id);
    //展示用户信息
    List<User> selectUser(Integer isDelete);
    //查看用户分布情况
    List<UserDistributionVO> getUserAgeGenderDistribution(Integer isDelete);




}
