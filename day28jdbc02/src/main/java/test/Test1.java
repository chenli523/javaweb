package test;

import bean.Account;
import com.mysql.cj.protocol.Resultset;
import org.junit.Test;
import utils.JDBCPoolUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Test1 {
    @Test
    public void test00() {
        Integer rdate = null;
        Integer ldate = null;
        if (rdate != ldate);
    }

    @Test
    public void test01() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCPoolUtils.getConnection();
        String sql = "select * from account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultset = preparedStatement.executeQuery();
        ArrayList<Account> accounts = new ArrayList<>();
        while(resultset.next()) {
            accounts.add(new Account(resultset.getInt(1),resultset.getString(2),resultset.getDouble(3)));
        }
        System.out.println(accounts);
        resultset.close();
        preparedStatement.close();
        connection.close();
    }

    // get metadata
    @Test
    public void test02() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCPoolUtils.getConnection();
        String sql = "select * from account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSetMetaData metaData = preparedStatement.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0 ; i < columnCount; i++) {
            System.out.println(metaData.getColumnName(i + 1));
            System.out.println(metaData.getColumnClassName(i + 1));
            //label is for allies
            System.out.println(metaData.getColumnLabel(i + 1));
            System.out.println(metaData.getTableName(i + 1));
        }
//        ResultSet resultset = preparedStatement.executeQuery();
//        ArrayList<Account> accounts = new ArrayList<>();
//        while(resultset.next()) {
//            accounts.add(new Account(resultset.getInt(1),resultset.getString(2),resultset.getDouble(3)));
//        }
//        System.out.println(accounts);
//        resultset.close();
        preparedStatement.close();
        connection.close();
    }
}
