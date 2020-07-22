package com.miguel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 转发和重定向
 * 以下方法不需要配置视图解析器InternalResourceViewResolver
 */
@Controller
public class ControllerTest4 {

    @GetMapping("/forward")
    public String testForward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 可以直接使用Request和Response
        HttpSession session = req.getSession();
        System.out.println(session.getId());

        //return "forward:/jsp/a.jsp";
        return "/WEB-INF/jsp/a.jsp";
    }

    @GetMapping("/redirect")
    public String testRedirect() {
        return "redirect:/index.jsp";
    }
}
