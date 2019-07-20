package com.example.jwt_token;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jwt_token.mapper")
public class JwtTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtTokenApplication.class, args);
    }

}
