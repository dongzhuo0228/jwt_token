package com.example.jwt_token.utils;

import com.alibaba.fastjson.JSON;
import com.example.jwt_token.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private final static String keyt = "79e7c69681b8270162386e6daa53d1dc";

    /**
     * 解密
     *
     * @param jsonWebToken
     * @return
     */
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(keyt.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     *
     * @param user
     * @return
     */
    public static String createJWT(User user) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(JSON.toJSONString(user))
                //设置过期时间
                .signWith(signatureAlgorithm, keyt.getBytes());
        //生成JWT
        return builder.compact();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setPassword("333333333333333333333333333333333333333333333");
        user.setId(11111111);
        user.setUsername("dddddddddddddd");
        //密钥
        String token = JwtUtil.createJWT(user);
        System.out.println("JWT加密的结果：" + token);
        System.out.println("JWT解密的结果：" + parseJWT(token));
    }

}
