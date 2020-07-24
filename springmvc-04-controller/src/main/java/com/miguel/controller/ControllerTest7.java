package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试乱码解决方案
 */
@Controller
@RequestMapping("/t7")
public class ControllerTest7 {

    @PostMapping("/test")
    public String test(String name, Model model) {
        model.addAttribute("msg", name);
        return "hello";
    }
}
