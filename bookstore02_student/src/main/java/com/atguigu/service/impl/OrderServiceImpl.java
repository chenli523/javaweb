package com.atguigu.service.impl;

import com.atguigu.bean.*;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemImpl;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, User user) {
        String orderId = null;
        try {
            // generating a unique order id with timestamp
            orderId = System.currentTimeMillis()+""+user.getId();
            // insert
            orderDao.insert(new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, user.getId()));
            // generating a order detail
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                Book book = cartItem.getBook();
                orderItemDao.insert(new OrderItem(null,
                        cartItem.getCount(),
                        cartItem.getAmount(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPrice(),
                        book.getImgPath(),
                        orderId));
                // change sales and stocks
                int newStock = book.getStock() - cartItem.getCount();
                int newSales = book.getSales() + cartItem.getCount();
                bookDao.updateBookById(newStock, newSales, book.getId());
            }
            // clearing the cart
            cart.clearCart();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }
}
