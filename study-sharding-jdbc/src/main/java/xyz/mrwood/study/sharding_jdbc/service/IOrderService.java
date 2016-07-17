/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding_jdbc.service;

import xyz.mrwood.study.sharding_jdbc.model.Order;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding_jdbc.xyz.mrwood.study.sharding_jdbc.service
 * 功能：
 * 时间：2016-07-17 12:39
 * 作者：Mr.Kiwi
 */
public interface IOrderService {

    /**
     * 通过订单号获得订单信息
     * @param orderId
     * @return
     */
    Order getByOrderId(String orderId);

    /**
     * 添加订单
     * @param order
     * @return
     */
    Integer addOrder(Order order);

}
