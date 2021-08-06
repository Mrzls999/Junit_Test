package javaWeb.shop.dao;

import javaWeb.shop.entity.OrderItem;
import javaWeb.shop.entity.Orders;

import java.sql.Connection;

public interface OrderDao {
    //插入订单
    void saveOrder(Connection connection, Orders orders);
    //插入订单项
    void saveOrderItem(Connection connection,OrderItem orderItem);
}
