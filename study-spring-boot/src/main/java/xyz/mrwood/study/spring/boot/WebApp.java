/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.mrwood.study.spring.boot.web.RequestListener;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.boot
 * 功能：spring boot启动类
 * 时间：2016-06-20 20:46
 * 作者：Mr.Kiwi
 */
@SpringBootApplication
public class WebApp {

    public static void main(String[] args) {

        SpringApplication.run(WebApp.class, args);

    }

    /**
     * request listener
     * @return
     */
    @Bean
    public RequestListener requestListener(){

        return new RequestListener();
    }
}
