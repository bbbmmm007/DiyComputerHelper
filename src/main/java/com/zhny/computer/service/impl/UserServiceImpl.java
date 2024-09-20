package com.zhny.computer.service.impl;

import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.User;
import com.zhny.computer.mapper.AdminMapper;
import com.zhny.computer.mapper.UserMapper;
import com.zhny.computer.service.UserService;
import com.zhny.computer.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    //用户注册的功能实现
    @Override
    public void reg(User user) {
        //调用findusername的方法
        String username = user.getUsername();
        //通过user.getaname()获取用户名
        User result = userMapper.findByUsername(username);
        if (result != null) {
            //异常抛出
            throw new UsernameDuplicatedException("用户被占用");
        }
        //密码加密处理：md5算法实现
        //补全用户第一次注册的信息,4个信息
        String oldPassword = user.getPassword();
        //获取盐值(随机生成)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //补全数据：记录盐值
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);
        //加密后的密码重新返回给uers
        user.setPassword(md5Password);


        user.setAge(user.getAge());
        user.setGender(user.getGender());

        user.setIsDelete(0);//是否删除设置为0，0表示未删除，1删除
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date now = new Date();
        user.setCreatedTime(now);
        user.setModifiedTime(now);

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("用户注册时发生未知错误");

        }

    }

    //用户登录功能的实现
    @Override
    public User login(String username, String password) {
        User result = userMapper.findByUsername(username);
        //检测用户是否存在
        if (username == null ) {

            throw new UserNotFoundException("用户不存在");

        }
        //检测用户密码是否匹配
        //1.先获取数据库中加密后的密码
        String oldPassword = result.getPassword();
        //2.比较用户输入的密码和数据库中的密码进行比较
        //2.1先获取盐值，上一次注册时生成的盐值
        String salt = result.getSalt();
        //2.2将用户输入的密码使用相同的md5加密算法后与数据库中的密码进行对比
        String newPassword = getMD5Password(password, salt);
        //判断is_delete字段是否为1，1表示被删除
        if(result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        //判断用户输入的密码是否正确
        if(!newPassword.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码错误");
        }
        //显示需要显示的用户id,用户名，头像
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }


    //更改密码的功能实现
    @Override
    public void changePassword(Integer uid,
                               String username,
                               String oldPassword,
                               String newPassword) {
        User result = userMapper.findByUid(uid);
        //判断uid是否为空，或用户是否被删除
        if(result == null || result.getIsDelete()==1) {
            throw new UserNotFoundException("用户不存在！");

        }
        //原密码与数据库中的密码进行比较、
        String oldMd5Password = getMD5Password(oldPassword, result.getSalt());//获取原来的密码
        if(!result.getPassword().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("原密码输入错误！");
        }
        //新密码与原密码进行比较
        String newMd5Password = getMD5Password(newPassword, result.getSalt());//获取需要更改的新密码
        if(newMd5Password.equals(oldMd5Password)) {
            throw new PasswordOldAndNewMatchException("新密码与原密码不能相同");

        }
        Integer rows = userMapper.updatePasswordByUid(uid,
                newMd5Password,username,new Date());
        if (rows != 1) {
            throw new UpdateException("发生未知错误，更新密码失败！");
        }


    }

    //用户信息显示的功能实现
    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);//获取uid
        if (result == null || result.getIsDelete()==1) {//检测用户是否存在
            throw new UserNotFoundException("用户没有被找到");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setAge(result.getAge());
        user.setGender(result.getGender());

        return user;
    }


    //修改用户信息的功能实现
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);//获取uid
        if (result == null || result.getIsDelete()==1) {//检测用户是否存在
            throw new UserNotFoundException("用户没有被找到");
        }
        user.setUid(uid);
        user.setUsername(username);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        user.setAge(user.getAge());
        user.setGender(user.getGender());

        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新数据时发生异常");
        }


    }
    //分页查询用户
    @Override
    public List<User> findUsersByPage(Integer amid,Integer pageNumber, Integer pageSize) {
        Admin result=adminMapper.findByAmid(amid);
        if(result == null) {
            throw new AdminNotFoundException("管理员数据不存在");
        }
        Integer offset = (pageNumber - 1) * pageSize;//pageNumber表示你想查询第几页  pageSize每页查询多少条数据
        return userMapper.findUsersByPage(pageSize,offset);
    }
    //统计用户数量
    @Override
    public Integer countUsers(Integer amid) {
        Admin result=adminMapper.findByAmid(amid);
        if(result == null) {
            throw new AdminNotFoundException("管理员数据不存在");
        }
        return userMapper.countUsers();
    }

    //定义一个md5算法的加密处理
    private String getMD5Password(String password, String salt) {
        for(int i = 0; i<3; i++){
            //进行3次加密
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();

        }
        return password;

    }
}
