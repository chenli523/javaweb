package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    static DataSource dataSource;
//    private static Connection connection = null;
//    wrong way cause thread is not safe
//    correct way: threadlocal
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

    }
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // create pool from druid.properties
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 1.get connection
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    // 2.close resources
    public static void releaseResources() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            try {
                connection.close();
                threadLocal.remove();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
    }
}
