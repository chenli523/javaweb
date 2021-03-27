package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter", value = "/*")
public class CharacterEncodingFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        // post messy code
        httpServletRequest.setCharacterEncoding("UTF-8");
        // for response messy code
        httpServletResponse.setContentType("text/html; charset=UTF-8");
        // let go
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
