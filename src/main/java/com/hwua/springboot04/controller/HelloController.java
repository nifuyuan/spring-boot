package com.hwua.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","张三");
        model.addAttribute("products",Arrays.asList("电脑","键盘","鼠标"));
        return "hello";
    }
}
