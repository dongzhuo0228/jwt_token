package com.example.jwt_token.service;

import com.example.jwt_token.model.User;

public interface IUserService {

    User findByUserId(int userId);
}
