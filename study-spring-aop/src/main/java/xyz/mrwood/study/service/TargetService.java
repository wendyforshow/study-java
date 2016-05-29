/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.service;

import org.springframework.stereotype.Component;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.service
 * 功能：被拦截的目标类
 * 时间：2016-05-28 10:32
 * 作者：Mr.Kiwi
 */
@Component
public class TargetService {

    public String hello(String name){

        return "hello " + name;
    }

    public String  test(){


        return "test";
    }
}
