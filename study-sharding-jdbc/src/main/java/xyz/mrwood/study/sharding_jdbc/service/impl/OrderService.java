/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding_jdbc.service.impl;

import org.springframework.stereotype.Service;
import xyz.mrwood.study.sharding_jdbc.dao.OrderMapperExt;
import xyz.mrwood.study.sharding_jdbc.model.Order;
import xyz.mrwood.study.sharding_jdbc.service.IOrderService;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding_jdbc.xyz.mrwood.study.sharding_jdbc.service.impl
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

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    @Override
    public Integer addOrder(Order order) {

        return orderMapperExt.insert(order);
    }
}
