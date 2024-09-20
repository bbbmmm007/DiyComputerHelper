package com.zhny.computer.service.impl;

import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.vo.UserDistributionVO;
import com.zhny.computer.mapper.AdminMapper;
import com.zhny.computer.mapper.ProductMapper;
import com.zhny.computer.mapper.UserMapper;
import com.zhny.computer.service.AdminService;
import com.zhny.computer.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;


    //管理员登录
    @Override
    public Admin login(String adminName, String password) {
        Admin result = adminMapper.findByname(adminName);
        if (result == null) {
            throw new UserNotFoundException("没有找到该用户相关信息");
        }
        if (!result.getPassword().equals(password)) {
            throw new PasswordNotMatchException("密码错误");
        }
        Admin admin = new Admin();
        admin.setAmid(result.getAmid());
        admin.setAdminName(result.getAdminName());

        return admin;

    }
    //注册管理员的实现
    @Override
    public void register(Admin admin) {
        //调用findusername的方法
        String adminName = admin.getAdminName();
        //通过user.getaname()获取用户名
        Admin result = adminMapper.findByname(adminName);
        if (result != null) {
            //异常抛出
            throw new UsernameDuplicatedException("用户被占用");
        }


        admin.setCreatedUser(admin.getAdminName());
        admin.setModifiedUser(admin.getAdminName());
        Date now = new Date();
        admin.setCreatedTime(now);
        admin.setModifiedTime(now);

        Integer rows = adminMapper.insert(admin);
        if (rows != 1) {
            throw new InsertException("用户注册时发生未知错误");

        }
    }

    //删除用户的实现
    @Override
    public void deleteUser(Integer amid,Integer uid) {
        Admin adResult=adminMapper.findByAmid(amid);
        if (adResult == null) {
            throw new AccessDeniedException("非法的数据操作");
        }
        adminMapper.deleteUser(uid);

    }




    //新增商品的实现
    @Override
    public void insertProduct(Integer amid,String adminName,Product product) {
        Admin adResult = adminMapper.findByAmid(amid);
        if(adResult==null){
            throw new UserNotFoundException("用户不存在");
        }
        product.setChildId(product.getChildId());
        product.setParentId(product.getParentId());
        product.setAncestorId(product.getAncestorId());
        product.setItemType(product.getItemType());
        product.setPrice(product.getPrice());
        product.setImage(product.getImage());
        product.setPerformanceScore(product.getPerformanceScore());
        product.setSalt(product.getSalt());
        product.setStatus(1);


        //补全四项日志
        product.setCreatedUser(adminName);
        product.setModifiedUser(adminName);
        product.setCreatedTime(new Date());
        product.setModifiedTime(new Date());

        Integer rows = adminMapper.insertProduct(product);
        if (rows != 1) {
            throw new InsertException("添加新商品失败");
        }


    }


    //更新商品信息
    @Override
    public void updateProduct(Integer amid, String adminName, Integer id, Product product) {

        Admin result = adminMapper.findByAmid(amid);
        if(result==null){
            throw new UserNotFoundException("用户不存在");
        }
        Product rusltPr = productMapper.findById(id);
        if(rusltPr ==null){
            throw new ProductNotFoundException("商品不存在");
        }

        product.setId(id);
        product.setStatus(1);

        Integer rows = adminMapper.updateProduct(product.getItemType(),product.getPrice(),product.getImage(),product.getSalt(),product.getPerformanceScore(),adminName,new Date(),id);
        if (rows != 1) {
            throw new UpdateException("更新数据失败");
        }
    }

    //删除商品
    @Override
    public void deleteProduct(Integer amid, Integer id) {
        Admin result=adminMapper.findByAmid(amid);
        if(result==null){
            throw new AccessDeniedException("非法的数据访问");
        }
        Product prResult = productMapper.findById(id);
        if(prResult==null){
            throw new ProductNotFoundException("商品不存在");
        }
        Integer rows = adminMapper.deleteProduct(id);
        if (rows != 1) {
            throw new DeleteException("删除商品数据失败");
        }
    }

    //根据amid注销管理员
    @Override
    public void deleteAdmin(Integer amid) {
        Admin result=adminMapper.findByAmid(amid);
        if(result==null){
            throw new AccessDeniedException("非法的数据访问");
        }
        Integer rows = adminMapper.deleteAdmin(result.getAmid());
        if (rows != 1) {
            throw new DeleteException("删除商品数据失败");
        }

    }

    //管理员修改密码
    @Override
    public void updateAdmin(Integer amid,String adminName,String oldPassword,String newPassword) {
        Admin result = adminMapper.findByAmid(amid);
        if(result==null){
            throw new AccessDeniedException("非法的数据访问");
        }
        if (oldPassword.equals(newPassword)) {
            throw new PasswordOldAndNewMatchException("新密码不能与旧密码相同");
        }
        Integer rows = adminMapper.updatePasswordByAmid(amid,newPassword,result.getAdminName(),new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据失败");
        }

    }

    //获取用户分布情况
    @Override
    public List<UserDistributionVO> getUserAgeGenderDistribution(Integer amid) {
        Admin result = adminMapper.findByAmid(amid);
        if(result==null){
            throw new AccessDeniedException("非法的数据访问");
        }
        return adminMapper.getUserAgeGenderDistribution(0);
    }

    //查询所有用户
    @Override
    public List<User> selectUser(Integer amid) {
        Admin result=adminMapper.findByAmid(amid);
        if(result==null){
            throw new AccessDeniedException("非法的数据访问");
        }
        List<User> list = adminMapper.selectUser(0);
            for (User user : list) {
                user.setUid(user.getUid());
                user.setUsername(user.getUsername());
                user.setGender(user.getGender());
                user.setAge(user.getAge());
           }
        return list;
   }

}


