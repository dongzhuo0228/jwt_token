package com.example.jwt_token.controller;

import com.example.jwt_token.model.User;
import com.example.jwt_token.service.IUserService;
import com.example.jwt_token.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ControllerApi extends BaseController {


    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Map login(@RequestBody  User user) {
        User userById = userService.findByUserId(user.getId());
        if (userById != null) {
            String token = JwtUtil.createJWT(user);
            return successResult(userById, token);
        } else {
            return failResult("信息验证失败");
        }
    }
    @RequestMapping("/getmessage")
    public Map getMessaage(@RequestBody  User user) {
       return successResult();
    }
}