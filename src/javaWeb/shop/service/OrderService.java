package javaWeb.shop.service;

import javaWeb.shop.entity.Orders;

import java.sql.Connection;

public interface OrderService {
    //向数据库插入订单
    int saveOrder(Orders orders);
}
