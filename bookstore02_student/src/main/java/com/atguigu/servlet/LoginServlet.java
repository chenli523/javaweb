package com.atguigu.servlet;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post messy code
        request.setCharacterEncoding("UTF-8");
        // for response messy code
        response.setContentType("text/html; charset=UTF-8");
        //
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUser(new User(username, null, password, null));
        if (user != null) {
            // redirect to login_success
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        } else {
            // forward to login
            request.setAttribute("msg","username or password is wrong, please renter");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
