/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot.mybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mrwood.study.spring.boot.mybatis.dao.ServiceOrderMapper;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot.mybatis.controller
 * 功能：
 * 时间：2016-06-29 13:31
 * 作者：Mr.Kiwi
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ServiceOrderMapper serviceOrderMapper;

    @RequestMapping("/mapper")
    public Object testMapper(){

        return serviceOrderMapper.selectAll();
    }
}
