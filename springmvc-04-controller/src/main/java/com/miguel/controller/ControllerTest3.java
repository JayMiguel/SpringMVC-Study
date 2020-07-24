package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @RequestMapping的用法
 */
@Controller
@RequestMapping("/t3")
public class ControllerTest3 {

    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("msg", "ControllerTest3");
        return "hello";
    }
}
