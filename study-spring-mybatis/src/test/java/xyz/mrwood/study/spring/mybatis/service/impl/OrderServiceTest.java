package xyz.mrwood.study.spring.mybatis.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import xyz.mrwood.study.spring.mybatis.service.IOrderService;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.mybatis.service.impl
 * 功能：
 * 时间：2016-07-17 12:48
 * 作者：Mr.Kiwi
 */
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class OrderServiceTest extends AbstractTestNGSpringContextTests {

    @Resource
    private IOrderService orderService;

    @Test
    public void testGetByOrderId() throws Exception {

//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//
//        OrderService orderService = context.getBean("orderService", OrderService.class);

        System.err.println(orderService.getByOrderId("123456"));
    }
}
