package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 接收Restful风格的路径变量
 */
@Controller
public class ControllerTest5 {

    //@RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    @GetMapping("/t5/{a}/{b}") // 这个注解与以上注解等价
    public String test2(@PathVariable int a, @PathVariable String b, Model model) {
        String result = a + b;
        model.addAttribute("result", "结果为：" + result);
        return "test";
    }
}
