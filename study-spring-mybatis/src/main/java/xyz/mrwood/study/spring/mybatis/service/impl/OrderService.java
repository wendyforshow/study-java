/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.mybatis.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import xyz.mrwood.study.spring.mybatis.dao.OrderMapperExt;
import xyz.mrwood.study.spring.mybatis.model.Order;
import xyz.mrwood.study.spring.mybatis.service.IOrderService;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.mybatis.service.impl
 * 功能：
 * 时间：2016-07-17 12:41
 * 作者：Mr.Kiwi
 */
@Service
public class OrderService implements IOrderService {

    @Resource
    private OrderMapperExt orderMapperExt;

    /**
     * 通过订单号获得订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public Order getByOrderId(String orderId) {


        return  orderMapperExt.selectByPrimaryKey(Integer.valueOf(orderId));
    }
}
