package xyz.mrwood.study.sharding_jdbc.service.impl;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import xyz.mrwood.study.sharding_jdbc.model.Order;
import xyz.mrwood.study.sharding_jdbc.service.IOrderService;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding_jdbc.service.impl
 * 功能：
 * 时间：2016-07-17 16:52
 * 作者：Mr.Kiwi
 */
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class OrderServiceTest extends AbstractTestNGSpringContextTests {

    @Resource
    private IOrderService orderService;

    @Test
    public void testGetByOrderId() throws Exception {

        System.err.println(orderService.getByOrderId("123455"));
    }

    @Test
    public void testAddOrder() throws Exception {

        Order order = new Order();
        order.setOrderId(123);
        order.setStatus("1");
        order.setUserId(1);

        System.err.println(orderService.addOrder(order));

    }
}
