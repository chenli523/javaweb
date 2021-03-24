package com.atguigu.basedao;

import com.atguigu.utils.JDBCPoolUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
    public int update(String sql, Object... objs) throws SQLException, IOException, ClassNotFoundException {
        //1. get connection
        Connection connection = JDBCPoolUtils.getConnection();
        //2. prepare sql
        //3. prepare echor
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (objs != null && objs.length > 0) {
            //4. setting values
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i+1,objs[i]);
            }
        }
        int i = preparedStatement.executeUpdate();
        return i;
    }

}
