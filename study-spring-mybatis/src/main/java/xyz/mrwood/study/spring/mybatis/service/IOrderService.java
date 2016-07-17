/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.spring.mybatis.service;

import xyz.mrwood.study.spring.mybatis.model.Order;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.spring.mybatis.service
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

}
