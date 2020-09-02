package com.miguel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "Hello";
    }

    @RequestMapping("/a1")
    public void a1(String username, HttpServletResponse response) throws IOException {
        System.out.println("a1:param" + username);
        if ("miguel".equals(username)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }
}
