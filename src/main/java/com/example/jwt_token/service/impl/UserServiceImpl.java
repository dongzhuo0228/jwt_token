package com.example.jwt_token.service.impl;

import com.example.jwt_token.mapper.UserMapper;
import com.example.jwt_token.model.User;
import com.example.jwt_token.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserId(int userId) {
        return userMapper.getUserById(userId);
    }
}
