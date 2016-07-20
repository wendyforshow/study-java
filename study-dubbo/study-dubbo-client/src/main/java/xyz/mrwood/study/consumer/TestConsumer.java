/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.mrwood.study.provider.IHelloProvider;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.consumer
 * 功能：
 * 时间：2016-07-20 15:14
 * 作者：Mr.Kiwi
 */
public class TestConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:spring-dubbo-client.xml");

        IHelloProvider helloProviderImpl =
            applicationContext.getBean("helloProvider", IHelloProvider.class);

        System.err.println(helloProviderImpl.hello("KIWI"));
    }

}
