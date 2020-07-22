package com.miguel.controller;

import com.miguel.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/t6")
public class ControllerTest6 {

    //前端传递过来的参数名与方法中的参数名相同时,会自动赋值
    @GetMapping("/test1")
    public String test1(String name) {

        System.out.println("接收到前端的参数为：" + name);

        return "test";
    }

    //前端传递过来的参数名与对象的属性名相同时，会自动赋值
    @GetMapping("/test2")
    public String test2(User user) {

        System.out.println("接收到前端的参数为：" + user);

        return "test";
    }

    //前端传递的参数名与方法的参数名不同时，可用@RequestParam指定参数名来匹配
    @GetMapping("/test3")
    public String test3(@RequestParam("username") String name) {
        System.out.println("接收到前端的参数为：" + name);
        return "test";
    }


}
