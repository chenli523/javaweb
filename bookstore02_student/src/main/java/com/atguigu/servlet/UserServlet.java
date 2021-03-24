package com.atguigu.servlet;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // post messy code
//        request.setCharacterEncoding("UTF-8");
//        // for response messy code
//        response.setContentType("text/html; charset=UTF-8");
//        String method = request.getParameter("method");
////        if ("login".equals(method)) {
////            login(request,response);
////        } else if ("regist".equals(method)) {
////            regist(request, response);
////        }
////        reflection
//        try {
//            Method declaredMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
//            declaredMethod.invoke(this, request, response);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        User user = userService.getUser(new User(username, password, null));
        if (user != null) {
            // redirect to login_success
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        } else {
            // forward to login
            request.setAttribute("msg","username or password is wrong, please renter");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String username = request.getParameter("username");
        final String pwd = request.getParameter("pwd");
        final String email = request.getParameter("email");
        User user = userService.checkUserName(username);
        if (user == null) {
            userService.saveUser(new User(username,  pwd, email));
            response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
        } else {
            request.setAttribute("msg","username/password is wrong, please renter");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
}
