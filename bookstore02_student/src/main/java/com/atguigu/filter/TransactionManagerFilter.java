package com.atguigu.filter;

import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(filterName = "TransactionManagerFilter", value = "/*")
public class TransactionManagerFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        Connection connection = JDBCUtils.getConnection();
        try {
            // open the transaction
            connection.setAutoCommit(false);
            // let go
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            // without e -> commit
            connection.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
            // with e -> rollback
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/pages/error/error500.jsp");
        } finally {
            JDBCUtils.releaseResources();
        }

    }
}
