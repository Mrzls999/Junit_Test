package javaWeb.shop.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDBUtils {

    private QueryRunner queryRunner = new QueryRunner();
    /**
     * 通用的增删改操作
     * 			sql: insert delete update
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object... params) {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        int count = 0;
        try {
            count = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return count;
    }

    /**
     * 获取一个对象
     *
     * @param sql
     * @param params
     * @return
     */
    //查询返回对象进一步封装
    public <T> T getBean(String sql,Class<T> type,Object...params) {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<T>(type),
                    params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return t;
    }


    /**
     * 获取所有对象
     * @param sql
     * @param params
     * @return
     */
    public <T> List<T> getBeanList(String sql, Class<T> type, Object... params) {
        // 获取连接
        Connection connection = JdbcUtils.getConnection();
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.releaseConnection(connection);
        }
        return list;
    }

}
