package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCPoolUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class DbUtilsBaseDao<T> {
    QueryRunner queryRunner = new QueryRunner();
    private Class<T> type;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public DbUtilsBaseDao() {
        Class clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] ts = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) ts[0];
    }
    public Object getSingleValue(String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        int count = 0;
        try {
            count = queryRunner.query(connection,sql, new ScalarHandler<>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection, null, null);
        }
        return count;
    }
    //add/delete/update
    public int update(String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        int result = 0;
        try {
            result = queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection,null,null);
        }
        return result;
    }
    public <T> List<T> getBeanList(Class<T> clazz, String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection,null,null);
        }
        return list;
    }
    public <T> T getBean(Class<T> clazz, String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection,null,null);
        }
        return t;
    }
    public List<Map<String,Object>> mapToList(String sql, Object...args) {
        Connection connection = JDBCPoolUtils.getConnection();
        List<Map<String,Object>> list = null;
        try {
            list = queryRunner.query(connection,sql, new MapListHandler(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCPoolUtils.releaseResources(connection,null,null);
        }
        return list;
    }
}
