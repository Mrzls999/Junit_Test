package javaWeb.shop.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource;

    static {
        try {
            //1、读取druip.properties文件
            Properties pro = new Properties();
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            //2、连接连接池
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //释放连接
    public static void releaseConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
