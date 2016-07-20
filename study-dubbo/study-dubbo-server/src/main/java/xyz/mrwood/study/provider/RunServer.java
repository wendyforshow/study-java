/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.provider
 * 功能：
 * 时间：2016-07-20 15:21
 * 作者：Mr.Kiwi
 */
public class RunServer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("spring-dubbo-server.xml");
        applicationContext.start();
        System.out.println("按任意键退出");
        System.in.read();
    }

}
