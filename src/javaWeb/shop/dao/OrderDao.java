package javaWeb.shop.dao;

import javaWeb.shop.entity.OrderItem;
import javaWeb.shop.entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDao {
    //插入订单
    int saveOrder(Connection connection,Orders orders) throws SQLException;
    //插入订单项
    int saveOrderItem(Connection connection,OrderItem orderItem) throws SQLException;
}
