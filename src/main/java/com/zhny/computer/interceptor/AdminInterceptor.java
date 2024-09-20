package com.zhny.computer.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 需要拦截的页面路径
    public static final List<String> INTERCEPTOR_PATHS = Arrays.asList(
            "/web/adminAddKnowledge.html",
            "/web/adminAddProduct.html",
            "/web/adminCategory.html",
            "/web/adminDeleteUser.html",
            "/web/adminEditKnowledge.html",
            "/web/adminEditProduct.html",
            "/web/adminKnowledge.html",
            "/web/adminManageProduct.html",
            "/web/adminSearchProduct.html",
            "/web/adminUserFenye.html",
            "/web/adminPassword.html"
    );

    // 放行的页面路径
    public static final List<String> EXCLUDE_PATHS = Arrays.asList(
            "/web/adminLogin.html",
            "/web/adminRegister.html"
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        HttpSession session = request.getSession();

        // 放行的页面直接返回 true
        if (EXCLUDE_PATHS.contains(requestUri)) {
            return true;
        }

        // 如果请求路径在需要拦截的页面中
        if (INTERCEPTOR_PATHS.contains(requestUri)) {
            // 从 session 中获取用户 ID 和用户名
            Integer amid = (Integer) session.getAttribute("amid");
            String adminName = (String) session.getAttribute("adminName");

            // 检查 session 中是否存在用户信息
            if (amid != null && adminName != null) {
                // 从 Redis 验证用户是否已登录
                String redisKey = "login:session:" + amid;
                Boolean isLoggedIn = redisTemplate.hasKey(redisKey);

                if (Boolean.TRUE.equals(isLoggedIn)) {
                    // Redis 中存在用户信息，继续执行请求
                    return true;
                } else {
                    // Redis 中没有用户信息，可能是 session 过期或用户未登录，重定向到登录页面
                    response.sendRedirect("/web/adminLogin.html");
                    return false;
                }
            } else {
                // Session 中没有用户信息，重定向到登录页面
                response.sendRedirect("/web/adminLogin.html");
                return false;
            }
        }

        // 其他请求放行
        return true;
    }
}
