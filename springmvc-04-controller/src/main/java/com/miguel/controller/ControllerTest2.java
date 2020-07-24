package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建Controller的第二种方式
 */
@Controller
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String hello(Model model) {

        model.addAttribute("msg", "ControllerTest2");
        
        return "hello";
    }
}
