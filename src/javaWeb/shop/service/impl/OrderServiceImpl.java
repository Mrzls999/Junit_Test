package javaWeb.shop.service.impl;

import javaWeb.shop.dao.OrderDao;
import javaWeb.shop.dao.impl.OrderDaoImpl;
import javaWeb.shop.entity.OrderItem;
import javaWeb.shop.entity.Orders;
import javaWeb.shop.service.OrderService;
import javaWeb.shop.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    /**
     * 插入订单
     * @param orders
     */
    @Override
    public void saveOrder(Orders orders) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            //插入订单
            OrderDao orderDao = new OrderDaoImpl();
            orderDao.saveOrder(connection,orders);
            //插入订单项
            List<OrderItem> list = orders.getList();
            for (OrderItem orderItem : list) {
                new OrderDaoImpl().saveOrderItem(connection,orderItem);
            }
            DbUtils.commitAndCloseQuietly(connection);
        }catch (Exception e){
            DbUtils.rollbackAndCloseQuietly(connection);
        }
    }
}
