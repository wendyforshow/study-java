/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding.jdbc.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.mrwood.study.sharding.jdbc.dao.OrderDao;
import xyz.mrwood.study.sharding.jdbc.model.Order;

import javax.annotation.Resource;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding.jdbc.service
 * 功能：
 * 时间：2016-07-16 0:08
 * 作者：Mr.Kiwi
 */
@Service
@Transactional
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Transactional(readOnly = true)
    public void select() {
        System.out.println(orderDao.selectAll());
    }

    public void clear() {
        orderDao.deleteAll();
    }

    public void fooService() {
        Order criteria = new Order();
        criteria.setUserId(10);
        criteria.setOrderId(1);
        criteria.setStatus("INSERT");
        orderDao.insert(criteria);
        criteria.setUserId(11);
        criteria.setOrderId(1);
        criteria.setStatus("INSERT2");
        orderDao.insert(criteria);
        orderDao.update(Lists.newArrayList(10, 11));
    }

    public void fooServiceWithFailure() {
        fooService();
        throw new IllegalArgumentException("failed");
    }
}
