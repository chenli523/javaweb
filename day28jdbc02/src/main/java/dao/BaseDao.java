package dao;

import utils.JDBCPoolUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseDao {
    //add/delete/update
    public int update(String sql, Object...objs) {
        Connection connection = JDBCPoolUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    preparedStatement.setObject(i+1,objs[i]);
                }
            }
            count = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection,preparedStatement,null);
        }
        return count;
    }
    public <T> T getBean(Class<T> clazz, String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        T t = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            set = preparedStatement.executeQuery();
            //get metadata
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            //encapsulation
            if (set.next()) {
                t = clazz.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object object = set.getObject(columnLabel);
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,object);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources( connection, preparedStatement, set );
        }
        return t;
    }
    public <T> List<T> getBeanList(Class<T> clazz, String sql, Object...args) {
        // result list
        List<T> list = new ArrayList<>();
        // connection
        Connection connection = JDBCPoolUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            set = preparedStatement.executeQuery();
            //get metadata
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            //encapsulation
            while (set.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object object = set.getObject(columnLabel);
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,object);
                }
                list.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources( connection, preparedStatement, set );
        }
        return list;
    }
    public List<Map<String,Object>> mapToList(String sql, Object...args) throws SQLException, IOException, ClassNotFoundException {
        //List
        List<Map<String, Object>> list = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            list = new ArrayList<>();
            //connection
            connection = JDBCPoolUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i+1, args[i]);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection, preparedStatement, null);
        }
        return list;
    }
}
