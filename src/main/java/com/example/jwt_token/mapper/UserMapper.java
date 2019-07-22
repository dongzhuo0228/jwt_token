package com.example.jwt_token.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jwt_token.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User getUserById(@Param("userId") int userId);
}
