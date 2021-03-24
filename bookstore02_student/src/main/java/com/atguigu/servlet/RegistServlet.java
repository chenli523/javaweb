package com.atguigu.servlet;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post messy code
        request.setCharacterEncoding("UTF-8");
        // for response messy code
        response.setContentType("text/html; charset=UTF-8");
        final String username = request.getParameter("username");
        final String pwd = request.getParameter("pwd");
        final String email = request.getParameter("email");
        User user = userService.checkUserName(username);
        if (user == null) {
            userService.saveUser(new User(username, null, pwd, email));
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
        } else {
            request.setAttribute("msg","username/password is wrong, please renter");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
