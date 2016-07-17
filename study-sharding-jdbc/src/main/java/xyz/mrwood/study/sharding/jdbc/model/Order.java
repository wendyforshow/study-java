/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.sharding.jdbc.model;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.sharding.jdbc.model
 * 功能：
 * 时间：2016-07-16 0:06
 * 作者：Mr.Kiwi
 */
public class Order {


    private int orderId;

    private int userId;

    private String status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(final int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("order_id: %s, user_id: %s, status: %s", orderId, userId, status);
    }

}
