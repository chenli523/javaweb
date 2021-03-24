package com.atguigu.servlet;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        2.
        List<Book> allBooks = bookService.getAllBooks();
//        3.
        request.setAttribute("list",allBooks);
//        4.
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void  getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pN = request.getParameter("pageNo");
//        2.
        Page<Book> booksByPage = bookService.getBooksByPage(pN);
//        3.
        request.setAttribute("page",booksByPage);
//        4.
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }


    protected void saveBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        2.
        String id = request.getParameter("id");
        int i = 0;
        try {
            if (id == null || "".equals(id)) {
                //add
                i = bookService.saveBook(new Book(
                        null,
                        request.getParameter("title"),
                        request.getParameter("author"),
                        Double.valueOf(request.getParameter("price")),
                        Integer.valueOf(request.getParameter("sales")),
                        Integer.valueOf(request.getParameter("stock")),
                        null));
            } else {
                //update
                i = bookService.updateBookById(new Book(
                        Integer.valueOf(id),
                        request.getParameter("title"),
                        request.getParameter("author"),
                        Double.valueOf(request.getParameter("price")),
                        Integer.valueOf(request.getParameter("sales")),
                        Integer.valueOf(request.getParameter("stock")),
                        null));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
//        3.
//        request.setAttribute("list",allBooks);
//        4.
        response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBooksByPage");
    }

    protected void deleteBookById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int i = bookService.deleteBookById(request.getParameter("id"));
        response.sendRedirect(request.getContextPath() + "/BookServlet?method=getBooksByPage");
    }

    protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bookService.getBookById(request.getParameter("id"));
        request.setAttribute("book", book);
        request.getRequestDispatcher( "pages/manager/book_edit.jsp").forward(request, response);
    }

}
