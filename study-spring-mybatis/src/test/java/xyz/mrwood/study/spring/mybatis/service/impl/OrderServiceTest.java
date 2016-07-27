package xyz.mrwood.study.spring.mybatis.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import xyz.mrwood.study.spring.mybatis.dao.OrderMapperExt;
import xyz.mrwood.study.spring.mybatis.service.IOrderService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    @Resource
    private OrderMapperExt orderMapperExt;

    @Test
    public void testGetByOrderId() throws Exception {

//
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//
//        OrderService orderService = context.getBean("orderService", OrderService.class);

        System.err.println(orderService.getByOrderId("123456"));
    }



    @Test
    public void testAddList(){

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("orderId", "11");
        map1.put("userId", "2222");


        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("orderId", "111");
        map2.put("userId", "22122");

        List<HashMap<String, Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        orderMapperExt.addList(list);
    }
}
