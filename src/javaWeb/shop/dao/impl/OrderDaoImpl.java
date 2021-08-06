package javaWeb.shop.dao.impl;

import javaWeb.shop.dao.OrderDao;
import javaWeb.shop.entity.OrderItem;
import javaWeb.shop.entity.Orders;
import javaWeb.shop.utils.BaseDBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoImpl extends BaseDBUtils implements OrderDao {
    /**
     * 插入订单
     *
     * @param orders
     */
    @Override
    public int saveOrder(Connection connection, Orders orders) throws SQLException {
        //插入订单数据
        String sql = "INSERT INTO t_orders VALUES(?,?,?,?,?)";
        Object[] params = {orders.getOid(), orders.getOrdersTime(), orders.getTotalPrice(), orders.getState(), orders.getUser().getUid()};
        return update_rollback(connection, sql, params);
    }

    /**
     * 插入订单项
     * @param orderItem
     */
    @Override
    public int saveOrderItem(Connection connection, OrderItem orderItem) throws SQLException {
        //插入订单项数据
        String sql_Item = "INSERT INTO t_ordersItem VALUES(?,?,?,?,?)";
        Object[] params_Item = {orderItem.getItemId(), orderItem.getCount(), orderItem.getAmount(), orderItem.getBook().getId(), orderItem.getOrder().getOid()};
        return update_rollback(connection,sql_Item, params_Item);
    }
}
