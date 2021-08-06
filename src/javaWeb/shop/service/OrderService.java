package javaWeb.shop.service;

import javaWeb.shop.entity.Orders;

public interface OrderService {
    //向数据库插入订单
    void saveOrder(Orders orders);
}
