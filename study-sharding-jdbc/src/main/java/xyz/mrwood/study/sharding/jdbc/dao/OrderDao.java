/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding.jdbc.dao;

import xyz.mrwood.study.sharding.jdbc.model.Order;

import java.util.List;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding.jdbc.dao
 * 功能：
 * 时间：2016-07-16 0:07
 * 作者：Mr.Kiwi
 */
public interface OrderDao {

    void insert(Order model);

    int update(List<Integer> userIds);

    int deleteAll();

    List<Order> selectAll();

}
