/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.mrwood.study.sharding.jdbc.service.OrderService;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding.jdbc
 * 功能：
 * 时间：2016-07-15 23:57
 * 作者：Mr.Kiwi
 */
@Service
@Transactional
public class ShardingMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatisContext.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.clear();
        orderService.fooService();
        orderService.select();

        //[order_id: 1, user_id: 10, status: UPDATED, order_id: 1, user_id: 11, status: UPDATED]
        orderService.clear();
        try {
            orderService.fooServiceWithFailure();
        } catch (final IllegalArgumentException e) {
            System.out.println("roll back");
        }
        //[]
        orderService.select();
    }

}
