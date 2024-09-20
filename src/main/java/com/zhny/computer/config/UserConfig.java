package com.zhny.computer.config;

import com.zhny.computer.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.zhny.computer.interceptor.UserInterceptor.INTERCEPTOR_PATHS;
import static com.zhny.computer.interceptor.UserInterceptor.EXCLUDE_PATHS;

@Configuration
public class UserConfig implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                // 拦截的路径
                .addPathPatterns(INTERCEPTOR_PATHS)
                // 放行的路径
                .excludePathPatterns(EXCLUDE_PATHS);
    }
}
