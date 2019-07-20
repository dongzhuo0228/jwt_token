package com.example.jwt_token.controller.interceptors;

import com.example.jwt_token.model.User;
import com.example.jwt_token.service.IUserService;
import com.example.jwt_token.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {


    private IUserService userService;

    public JwtInterceptor(IUserService iUserService){
        this.userService = iUserService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
       /* if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();*/
        Claims claims = JwtUtil.parseJWT(token);
        if(claims == null){
            throw new Exception("您的token沒有通过验证 非法用户");
        }
        User user = userService.findByUserId(Integer.parseInt(String.valueOf(claims.get("id"))));
        if(user!=null){
            return true;
        }
        return  false;
    }
}
