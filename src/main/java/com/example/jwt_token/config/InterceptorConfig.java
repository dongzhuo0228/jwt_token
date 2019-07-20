package com.example.jwt_token.config;

import com.example.jwt_token.controller.interceptors.JwtInterceptor;
import com.example.jwt_token.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private IUserService userService;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(userService)).addPathPatterns("/**").excludePathPatterns("/api/login");
    }
}
