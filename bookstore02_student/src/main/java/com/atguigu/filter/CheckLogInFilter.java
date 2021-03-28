package com.atguigu.filter;

import com.atguigu.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckLogInFilter", value = "/OrderServlet")
public class CheckLogInFilter extends HttpFilter {

    // check logged in or not
    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // hasnt log in
            httpServletRequest.setAttribute("msg","Please log in before checking out");
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            // has logged in
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
