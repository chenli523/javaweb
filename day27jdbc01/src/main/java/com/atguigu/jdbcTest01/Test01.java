package com.atguigu.jdbcTest01;

import org.junit.Test;

import java.sql.*;

import static java.lang.Class.forName;


public class Test01 {
    @Test
    public void test01() throws SQLException {
        //register driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //set up connection
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String user = "root";
        String passwd = "mysqlroot";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        //create commend sending tool
        Statement statement = connection.createStatement();
        //prepare sql
        String sql = "insert into users values(null, 'libai', '1234')";
        //execute sql
        int i = statement.executeUpdate(sql);
        //output result
        System.out.println(i);
        //close the resources
        statement.close();
        connection.close();
    }
    @Test
    public void test02() throws ClassNotFoundException, SQLException {
        //1.register driver
        //reflection
        Class.forName("com.mysql.jdbc.Driver");
        //2.set up connection
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String user = "root";
        String passwd = "mysqlroot";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        //3.create commend sending tool
        Statement statement = connection.createStatement();
        //4.prepare sql
        String sql = "update users set password='1234' where id = 2";
        //5.execute sql
        int i = statement.executeUpdate(sql);
        //6.output result
        System.out.println(i);
        //7.close the resources
        statement.close();
        connection.close();
    }

    @Test
    public void test03() throws ClassNotFoundException, SQLException {
        //1.register driver
        //service provider interface
        Class.forName("com.mysql.jdbc.Driver");
        //2.set up connection
        // "jdbc:mysql:///atguigu" for local database
        String url = "jdbc:mysql://localhost:3306/atguigu";
        String user = "root";
        String passwd = "mysqlroot";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        //3.create commend sending tool
        Statement statement = connection.createStatement();
        //4.prepare sql
        String sql = "delete from users where id = 2";
        //5.execute sql
        //for add, delete, update
        int i = statement.executeUpdate(sql);
        //6.output result
        System.out.println(i);
        //7.close the resources
        statement.close();
        connection.close();
    }
}
