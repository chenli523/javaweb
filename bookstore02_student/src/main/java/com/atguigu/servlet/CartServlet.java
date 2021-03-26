package com.atguigu.servlet;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.get param
        String bookId = request.getParameter("bookId");
        // 2.service
        Book bookById = bookService.getBookById(bookId);
        // 3.get cart from the session
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(bookById);
        // 4.forward/redirect to last url -> referer
        String referer = request.getHeader("referer");
        response.sendRedirect(referer);
    }

    protected void deleteItemById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.get param
        String bookId = request.getParameter("bookId");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(bookId);
        }
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }

    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.clearCart();
        }
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }
    protected void updateItemCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bookId = request.getParameter("bookId");
        String count = request.getParameter("count");
//        System.out.println(bookId + count);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            cart.updateItemCount(bookId, count);
        }
        response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
    }
}
