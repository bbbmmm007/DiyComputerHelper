package com.zhny.computer.controller;

import com.zhny.computer.entity.Admin;
import com.zhny.computer.entity.Product;
import com.zhny.computer.entity.User;
import com.zhny.computer.vo.UserDistributionVO;
import com.zhny.computer.service.AdminService;
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
@RequestMapping("admin")
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 登录的映射
    @RequestMapping("login")
    public JsonResult<Admin> login(String adminName, String password, HttpSession session) {
        Admin data = adminService.login(adminName, password);
        // 在 session 中绑定用户数据
        session.setAttribute("amid",data.getAmid());
        session.setAttribute("adminName",data.getAdminName());

        // 将用户信息存入 Redis，提升性能
        redisTemplate.opsForValue().set("login:session:" + data.getAmid(), data, 30, TimeUnit.MINUTES);

        // 获取 session 绑定中的数据
        System.out.println(getUidFromSession(session));
        System.out.println(getUsernameFromSession(session));

        return new JsonResult<Admin>(SUCCESS, data);
    }

    // 退出登录的映射
    @RequestMapping("logout")
    public JsonResult<Void> logout(HttpSession session) {

        Integer amid = getAmidFromSession(session);
        String adminName = getAdminNameFromSession(session);

        // 清除 session 中的用户信息
        session.removeAttribute("amid");
        session.removeAttribute("adminName");
        // 如果 amid 不为 null，清除 Redis 中的登录信息
        if (amid != null) {
            redisTemplate.delete("login:session:" + amid);
        }

        if (adminName != null) {
            redisTemplate.delete("login:session:" + adminName);
        }
        // 返回成功状态
        return new JsonResult<>(SUCCESS);
    }

    //管理员注册的接口
    @RequestMapping("register")
    public JsonResult<Void> register(Admin admin) {
        adminService.register(admin);
        return new JsonResult<Void>(SUCCESS);
    }

    // 管理员删除用户的接口
    @RequestMapping("/delete_user/{uid}")
    public JsonResult<Void> deleteUser(HttpSession session, @PathVariable("uid") Integer uid) {
        Integer amid = getAmidFromSession(session);

        adminService.deleteUser(amid,uid);
        return new JsonResult<Void>(SUCCESS);
    }

    // 管理员新增商品的接口
    @RequestMapping("/add_product")
    public JsonResult<Void> insertProduct(HttpSession session, Product product) {
        Integer amid = getAmidFromSession(session);
        String adminName = getAdminNameFromSession(session);
        adminService.insertProduct(amid, adminName, product);
        return new JsonResult<Void>(SUCCESS);
    }

    // 管理员更新商品信息的接口
    @RequestMapping("/update_product/{id}")
    public JsonResult<Void> updateProduct(HttpSession session,@PathVariable("id")
                                          Integer id,
                                          Product product) {
        Integer amid = getAmidFromSession(session);
        String adminName = getAdminNameFromSession(session);
        adminService.updateProduct(amid, adminName, id, product);
        return new JsonResult<Void>(SUCCESS);
    }
    //注销管理员的接口
    @RequestMapping("/delete_admin")
    public JsonResult<Void> deleteAdmin(HttpSession session) {
        Integer amid = getAmidFromSession(session);
        adminService.deleteAdmin(amid);
        return new JsonResult<Void>(SUCCESS);
    }
    //管理员更新密码的接口
    @RequestMapping("/update")
    public JsonResult<Void> updateAdmin(String oldPassword,
                                        String newPassword, HttpSession session) {
        Integer amid = getAmidFromSession(session);
        String adminName = getAdminNameFromSession(session);
        adminService.updateAdmin(amid,adminName,oldPassword,newPassword);
        return new JsonResult<Void>(SUCCESS);
    }
    // 管理员删除商品的接口
    @RequestMapping("/delete_product/{id}")
    public JsonResult<Void> deleteProduct(HttpSession session,
                                          @PathVariable("id") Integer id) {
        Integer amid = getAmidFromSession(session);
        adminService.deleteProduct(amid, id);
        return new JsonResult<>(SUCCESS);
    }
    // 显示所有用户的接口
    @RequestMapping("/users")
    public JsonResult<List<User>> selectUser(HttpSession session) {
        Integer amid = getAmidFromSession(session);
        List<User> users = adminService.selectUser(amid);
        return new JsonResult<>(SUCCESS, users);
    }
    //展示用户分布情况的接口
    @RequestMapping("/user_distribution")
    public JsonResult<List<UserDistributionVO>> getUserAgeGenderDistribution(HttpSession session) {
        Integer amid = (Integer) session.getAttribute("amid"); // 从 session 中获取 admin ID
        List<UserDistributionVO> distribution = adminService.getUserAgeGenderDistribution(amid);
        return new JsonResult<>(SUCCESS,distribution);
    }

}


