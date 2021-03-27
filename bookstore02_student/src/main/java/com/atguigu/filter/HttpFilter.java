package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class HttpFilter implements Filter {
    private FilterConfig filterConfig;

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public ServletContext getServeletContext() {
        return filterConfig.getServletContext();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        doFilter(request, response, filterChain);
    }

    public abstract void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
