package com.example.jwt_token.controller;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    public Map<String, Object> successResult() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","请求成功!");
        return map;
    }

    public Map<String, Object> successResult(Object msg) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg",msg);
        return map;
    }

    public Map<String, Object> successResult(String msg, Object object) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg",msg);
        map.put("data",object);
        return map;
    }

    public Map<String, Object> successResult(Object object,String token) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","请求成功!");
        map.put("data",object);
        map.put("token",token);
        return map;
    }

    public Map<String, Object> failResult() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code","-1");
        map.put("msg","请求失败!");
        return map;
    }

    public Map<String, Object> failResult(String msg) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code","-1");
        map.put("msg",msg);
        return map;
    }

    public Map<String, Object> successPageResult(int count, int limit, Object object) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("count", count);
        map.put("limit", limit);
        map.put("data", object);
        return map;
    }


}
