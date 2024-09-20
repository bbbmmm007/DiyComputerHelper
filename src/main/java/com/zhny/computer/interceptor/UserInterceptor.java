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
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 需要拦截的页面路径
    public static final List<String> INTERCEPTOR_PATHS = Arrays.asList(
            "/web/collection.html",
            "/web/profileCarts.html",
            "/web/autoCreateProfileBySelect.html",
            "/web/userProfile.html",
            "/web/AI.html",
            "/web/autoCreateProfile.html",
            "/web/profileList.html",
            "/web/recommendProfile.html",
            "/web/searchProduct.html"
    );

    // 放行的页面路径
    public static final List<String> EXCLUDE_PATHS = Arrays.asList(
            "/web/login.html",
            "/web/register.html",
            "/web/kowledge.html",
            "/web/index.html",
            "/web/product.html"
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
            Integer uid = (Integer) session.getAttribute("uid");
            String username = (String) session.getAttribute("username");

            // 检查 session 中是否存在用户信息
            if (uid != null && username != null) {
                // 从 Redis 验证用户是否已登录
                String redisKey = "login:session:" + uid;
                Boolean isLoggedIn = redisTemplate.hasKey(redisKey);

                if (Boolean.TRUE.equals(isLoggedIn)) {
                    // Redis 中存在用户信息，继续执行请求
                    return true;
                } else {
                    // Redis 中没有用户信息，可能是 session 过期或用户未登录，重定向到登录页面
                    response.sendRedirect("/web/login.html");
                    return false;
                }
            } else {
                // Session 中没有用户信息，重定向到登录页面
                response.sendRedirect("/web/login.html");
                return false;
            }
        }

        // 其他请求放行
        return true;
    }
}
