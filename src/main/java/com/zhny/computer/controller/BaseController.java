package com.zhny.computer.controller;


import com.zhny.computer.service.ex.*;
import com.zhny.computer.service.ex.ProductNotFoundException;
import com.zhny.computer.service.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


/**
 * 控制层类的基类
 */
public class BaseController {
    public static final int SUCCESS = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        }
        else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在");

        }
        else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("密码不匹配");

        }
        else if (e instanceof UpdateException) {
            result.setState(4003);
            result.setMessage("更新数据时发生未知错误");
        }
         else if (e instanceof AccessDeniedException) {
            result.setState(4006);
            result.setMessage("用户非法访问的异常");

        }
         else if (e instanceof DeleteException) {
            result.setState(4007);
            result.setMessage("删除数据时产生异常");
        }
        else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时发生未知错误");

        }
        else if (e instanceof ProductNotFoundException) {
            result.setState(5001);
            result.setMessage("添加商品进入购物车时没有找到商品信息的异常");

        } else if (e instanceof CartProfileNotFoundException) {
            result.setState(5002);
            result.setMessage("用户购物车数据不存在");

        }
        return result;
    }


    // 从 session 获取 uid，增加空值处理
    protected final Integer getUidFromSession(HttpSession session) {
        Object uid = session.getAttribute("uid");
        return (uid != null) ? Integer.valueOf(uid.toString()) : null; // 返回 null 如果 uid 不存在
    }
    // 从 session 获取 username，增加空值处理
    protected final String getUsernameFromSession(HttpSession session) {
        Object username = session.getAttribute("username");
        return (username != null) ? username.toString() : null; // 返回 null 如果 username 不存在
    }


    protected final Integer getAmidFromSession(HttpSession session) {
        Object amid = session.getAttribute("amid");
        return (amid != null) ? Integer.valueOf(amid.toString()) : null;

    }
    protected final String getAdminNameFromSession(HttpSession session) {

        Object adminName = session.getAttribute("adminName");
        return (adminName != null) ? adminName.toString() : null;
    }
}
