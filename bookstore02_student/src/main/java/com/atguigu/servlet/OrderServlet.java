package com.atguigu.servlet;

import com.atguigu.bean.Cart;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    protected void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. get request params
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");

        // 2. call service
        String orderId = orderService.createOrder(cart, user);
        // 3. saving data to session
        session.setAttribute("orderId", orderId);
        // 4. redirect
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
