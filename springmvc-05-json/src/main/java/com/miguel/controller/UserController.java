package com.miguel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Controller 走视图解析器
@RestController // 不走视图解析器
public class UserController {

    // Jackson转换Java对象
    // @ResponseBody
    @RequestMapping("/j1")
    public String json1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        User user = new User("基德", 3, "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }

    // Jackson转换集合
    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        User user1 = new User("基德1号", 3, "男");
        User user2 = new User("基德2号", 3, "男");
        User user3 = new User("基德3号", 3, "男");
        User user4 = new User("基德4号", 3, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = mapper.writeValueAsString(userList);
        return str;
    }

    // Jackson格式化日期
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        mapper.setDateFormat(fmt);

        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }

    @RequestMapping("/j4")
    public String json4() {
        User user1 = new User("基德1号", 3, "男");
        User user2 = new User("基德2号", 3, "男");
        User user3 = new User("基德3号", 3, "男");
        User user4 = new User("基德4号", 3, "男");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(userList)==>" + str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>" + str2);

        System.out.println("*******JSON字符串 转 Java对象*******");
        User jp_user = JSON.parseObject(str2, User.class);
        System.out.println("JSON.parseObject(str2, User.class)==>" + jp_user);

        System.out.println("*******Java对象 转 JSON对象*******");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(jp_user);
        System.out.println("(JSONObject) JSON.toJSON(user)==>" + jsonObject);

        System.out.println("*******JSON对象 转 Java对象*******");
        User to_java_user = JSON.toJavaObject(jsonObject, User.class);
        System.out.println("JSON.toxJavaObject(jsonObject, User.class)==>" + to_java_user);

        return "Hello";
    }
}
