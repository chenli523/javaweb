package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCPoolUtils {
    static DataSource dataSource;

    public static void main(String[] args) {

    }
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCPoolUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            // create pool from druid.properties
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 1.get connection
    public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        Connection connection = dataSource.getConnection();
        return connection;
    }
    // 2.close resources
    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
