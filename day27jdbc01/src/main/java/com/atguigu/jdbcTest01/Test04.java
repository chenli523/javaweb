package com.atguigu.jdbcTest01;

import org.junit.Test;

import java.sql.*;

public class Test04 {
    @Test
    public void test01() {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection = null;
        try {
            // 1 driver manager
            Class.forName("com.mysql.jdbc.Driver");
            // 2 connection
            connection = DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true", "root","mysqlroot");
            // 3 sql
            String sql1 = "upadte account set balance = balance - 500 where last_name = 'libai'";
            String sql2 = "upadte account set balance = balance + 500 where last_name = 'dufu'";
            // 4 statement
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            // 5 execute sql
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            // 6 show result
            System.out.println("successes");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8 close
            try {
                preparedStatement1.close();
                preparedStatement2.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //Affairs
    @Test
    public void test02() {
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        Connection connection = null;
        try {
            // 1 driver manager
            Class.forName("com.mysql.jdbc.Driver");
            // 2 connection
            connection = DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true", "root","mysqlroot");
            // set affairs
            connection.setAutoCommit(false);
            // 3 sql
            String sql1 = "upadte account set balance = balance - 500 where last_name = 'libai'";
            String sql2 = "upadte account set balance = balance + 500 where last_name = 'dufu'";
            // 4 statement
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            // 5 execute sql
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            // commit
            connection.commit();
            // 6 show result
            System.out.println("successes");
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 8 close
            try {
                preparedStatement1.close();
                preparedStatement2.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
