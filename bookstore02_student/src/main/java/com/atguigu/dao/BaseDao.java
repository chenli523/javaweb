package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BaseDao<T> {
    QueryRunner queryRunner = new QueryRunner();
    private Class<T> type;
    public BaseDao() {
        Class clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] ts = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) ts[0];
    }
    public Object getSingleValue(String sql, Object...args){
        Connection connection = null;
        Object count = null;
        try {
            connection = JDBCUtils.getConnection();
            count = queryRunner.query(connection,sql, new ScalarHandler<>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.releaseResources(connection, null, null);
        }
        return count;
    }
    //add/delete/update
    public int update(String sql, Object...args) {
        Connection connection = null;
        int result = 0;
        try {
            connection = JDBCUtils.getConnection();
            result = queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.releaseResources(connection,null,null);
        }
        return result;
    }
    public List<T> getBeanList(String sql, Object... params) {
        // 获取连接
        Connection connection = JDBCUtils.getConnection();
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<T>(
                    type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseResources(connection,null,null);
        }
        return list;
    }
//    public <T> List<T> getBeanList(Class<T> clazz, String sql, Object...args) {
//        Connection connection = null;
//        List<T> list = null;
//        try {
//            connection = JDBCUtils.getConnection();
//            list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            JDBCUtils.releaseResources(connection,null,null);
//        }
//        return list;
//    }
    public <T> T getBean(Class<T> clazz, String sql, Object...args) {
        Connection connection = JDBCUtils.getConnection();
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.releaseResources(connection,null,null);
        }
        return t;
    }
    public List<Map<String,Object>> mapToList(String sql, Object...args) {
        Connection connection = JDBCUtils.getConnection();
        List<Map<String,Object>> list = null;
        try {
            list = queryRunner.query(connection,sql, new MapListHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.releaseResources(connection,null,null);
        }
        return list;
    }
}
