package com.atguigu.jdbcTest01;

import com.atguigu.basedao.BaseDao;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class Test05 {
    BaseDao baseDao = new BaseDao();
    @Test
    public void test01() throws SQLException, IOException, ClassNotFoundException {
        String sql = "insert into account values(null, ?, ?)";
        Object[] obj = {"caixukun", 500};
        int i = baseDao.update(sql, obj);
        System.out.println(i);
    }
}
