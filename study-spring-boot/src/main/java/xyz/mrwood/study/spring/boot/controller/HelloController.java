/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mrwood.study.spring.boot.service.HelloService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot
 * 功能：
 * 时间：2016-06-14 1:30
 * 作者：Mr.Kiwi
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping("/home")
    @ResponseBody
    public String home(HttpServletRequest request) throws Exception {


       int i = 1 / 0;
        helloService.testThreadLocal();

        return "hello spring boot!";
    }
}
