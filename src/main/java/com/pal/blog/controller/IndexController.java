package com.pal.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author pal
 * @Date Created in 2020/7/12 17:42
 * @Version: 1.0
 */
@Controller
public class IndexController {
    //通过get方式请求路径
    @GetMapping("/")
    public String index(){

        return "index";
    }
}