package com.example.jwt_token.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.jwt_token.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select id,username,password from user where id =#{userId}")
    User getUserById(@Param("userId") int userId);
}
