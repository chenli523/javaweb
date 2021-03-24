package com.atguigu.servlet;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookClientServlet", value = "/BookClientServlet")
public class BookClientServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pN = request.getParameter("pageNo");
//        2.
        Page<Book> booksByPage = bookService.getBooksByPage(pN);
//        3.
        request.setAttribute("page",booksByPage);
//        4.
        request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request,response);
    }

    protected void getBooksByPageAndPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pN = request.getParameter("pageNo");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
//        2.
        Page<Book> booksByPage = bookService.getBooksByPageAndPrice(pN, minPrice, maxPrice);
//        3.
        request.setAttribute("page",booksByPage);
//        4.
        request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request,response);
    }
}
