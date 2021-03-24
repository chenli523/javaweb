package com.atguigu.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.SQLException;

public class DruidTest {
    @Test
    public void test01() throws SQLException {
        //1 create object
        DruidDataSource ds = new DruidDataSource();
        //2 settings
        ds.setUsername("root");
        ds.setPassword("mysqlroot");
        ds.setUrl("jdbc:mysql:///atguigu");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //pool setting
        ds.setInitialSize(5);
        ds.setMaxActive(10);
        //3 max wait time
        ds.setMaxWait(2000);
        //4 get connection
        DruidPooledConnection connection = null;
        for (int i = 0; i < 20; i++) {
            try {
                connection = ds.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                connection.close();
            }
        }
    }

}
