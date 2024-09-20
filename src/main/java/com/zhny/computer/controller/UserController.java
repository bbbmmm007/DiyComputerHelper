package com.zhny.computer.controller;


import com.zhny.computer.entity.User;
import com.zhny.computer.service.UserService;
import com.zhny.computer.service.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //注册的映射
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<Void>(SUCCESS);
    }

    // 登录的映射
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        // 在 session 中绑定用户数据
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());

        // 将用户信息存入 Redis，提升性能
        redisTemplate.opsForValue().set("login:session:" + data.getUid(), data, 30, TimeUnit.MINUTES);

        // 获取 session 绑定中的数据
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<>(SUCCESS, data);
    }

    // 退出登录的映射
    @RequestMapping("logout")
    public JsonResult<Void> logout(HttpSession session) {
        // 获取用户的 uid
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 清除 session 中的用户信息
        session.removeAttribute("uid");
        session.removeAttribute("username");
        // 如果 uid 不为 null，清除 Redis 中的数据
        if (uid != null) {
            redisTemplate.delete("login:session:" + uid);
        }

        if (username != null) {
            redisTemplate.delete("login:session:" + username);
        }
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));
        return new JsonResult<>(SUCCESS);
    }
    //更改密码的映射
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(SUCCESS);
    }

    //查询显示个人信息的映射(数据回显)
    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data =
                userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(SUCCESS, data);

    }

    //更改个人信息的映射
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,
                                       HttpSession session) {

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(SUCCESS);

    }
    //分页查询用户
    @RequestMapping("/show_fenye_user/{pageNumber}/{pageSize}")
    public JsonResult<List<User>> showFenUser(HttpSession session,@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize) {
        Integer amid=getAmidFromSession(session);
        List<User> list = userService.findUsersByPage(amid,pageNumber,pageSize);
        return new JsonResult<>(SUCCESS,list);
    }
    //返回用户总数
    @RequestMapping("/count_user")
    public JsonResult<Integer> countUser(HttpSession session) {
        Integer amid=getAmidFromSession(session);
        Integer countUser = userService.countUsers(amid);
        return new JsonResult<>(SUCCESS,countUser);
    }

}

