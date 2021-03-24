package com.atguigu.jdbcTest01;

import org.junit.Test;

import java.sql.*;

public class Test02 {
    @Test
    public void test02() throws ClassNotFoundException, SQLException {
        //1.register driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.connection
        String url = "jdbc:mysql:///atguigu";
        String user = "root";
        String passwd = "mysqlroot";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        //3.statement
        Statement statement = connection.createStatement();
        String sql = "select * from users";
        //4.execute sql
        ResultSet i = statement.executeQuery(sql);
        //5. check response
        while(i.next()) {
            System.out.print(i.getInt(1));
            System.out.print(i.getString(2));
            System.out.println(i.getObject(3));
        }
        //6. close
        statement.close();
        connection.close();
    }
}
