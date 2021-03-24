package com.atguigu.jdbcTest01;

import com.atguigu.bean.User;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
    @Test
    public void test02() throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input your name");
        String userName = in.next();
        System.out.println("Please input your password");
        in.nextLine();
        String userPass = in.next();

        ArrayList<User> res = judgeUser(userName, userPass);
    }
    @Test
    public void test03() throws ClassNotFoundException, SQLException, IOException {
        // 1 driver manager
        Class.forName("com.mysql.jdbc.Driver");
        // 2 connection
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root","mysqlroot");
        // 3 sql
        String sql = "insert into photo values(null, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        InputStream is = new FileInputStream("/Users/a123/Desktop/DR590/assignment1/ucc-j-2020.01.jar.png");
        preparedStatement.setObject(1,is);
        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        is.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void test04() throws ClassNotFoundException, SQLException, IOException {
        // 1 driver manager
        Class.forName("com.mysql.jdbc.Driver");
        // 2 connection
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu", "root","mysqlroot");
        // 3 sql
        String sql = "insert into users values(null, ?, ?)";
        // 4 statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setObject(1, "baiyang");
        preparedStatement.setObject(2, "56789");
        // 5 execute
        int i = preparedStatement.executeUpdate();
        // 6 show result
        System.out.println(i);
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            Object object = generatedKeys.getObject(1);
            System.out.println(object);
        }
        // 7 close
        preparedStatement.close();
        connection.close();
    }

    // saving works together to execute
    @Test
    public void test05() throws ClassNotFoundException, SQLException, IOException {
        // should use try catch
        // 1 driver manager
        Class.forName("com.mysql.jdbc.Driver");
        // 2 connection
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu?rewriteBatchedStatements=true", "root","mysqlroot");
        // 3 sql
        String sql = "insert into users values(null, ?, ?)";
        // 4 statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int j = 0; j < 100; j++) {
            preparedStatement.setObject(1, "baiyang");
            preparedStatement.setObject(2, "56789");
            // 5 save works together
            preparedStatement.addBatch();
        }
        // 6 execute
        int[] ints = preparedStatement.executeBatch();
//        // 7 show result
//        System.out.println(ints);
//        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//        if (generatedKeys.next()) {
//            Object object = generatedKeys.getObject(1);
//            System.out.println(object);
//        }
        // 8 close
        preparedStatement.close();
        connection.close();
    }



    private ArrayList<User> judgeUser(String userName, String userPass) throws ClassNotFoundException, SQLException {
        ArrayList<User> result = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu","root", "mysqlroot");
        //Statement statement = connection.createStatement();
//        String sql = "insert into users values(null,'"+userName+"','"+userPass+"')";
        // sql conjunction problem
        String sql = "select * from users where user_name=? or password=?";
//        String sql = "insert into users values(null, ?, ?)";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);
        preparedStatement.setObject(1,userName);
        preparedStatement.setObject(2,userPass);
        ResultSet i = preparedStatement.executeQuery(sql);
        while (i.next()) {
            User user = new User();
            user.setId(i.getInt(1))
                    .setUserName(i.getString(2))
                    .setPasswd(i.getString(3));
        }
        preparedStatement.close();
        connection.close();
        return result;
    }
}
