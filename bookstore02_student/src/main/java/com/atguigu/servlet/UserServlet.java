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
        HttpSession session = request.getSession();
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        User user = userService.getUser(new User(username, password, null));
        if (user != null) {
            // redirect to login_success
            session.setAttribute("user", user);
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
        //auth code and session one
        String authCode = request.getParameter("authCode");
        HttpSession session = request.getSession();
        Object sessionVal = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (sessionVal != null && sessionVal.toString().equals(authCode)) {
            // auth code correct
            // fail the code
            session.removeAttribute("KAPTCHA_SESSION_KEY");
            // check userinfo
            User user = userService.checkUserName(username);
            if (user == null) {
                userService.saveUser(new User(username,  pwd, email));
                response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
            } else {
//                System.out.println("username is existed, please renter");
                request.setAttribute("msg","username is existed, please renter");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        } else {
            // incorrect auth code
            request.setAttribute("authCodeMsg","auth code incorrect, please renter");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }

    }

    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    // ajax
    protected void checkUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String unValue = request.getParameter("unValue");
        // service
        User user = userService.checkUserName(unValue);
        if (user == null) {
            // user is not exist
            response.getWriter().write("true");
        } else {
            // user is existed
            response.getWriter().write("false");
        }
    }
}
