package com.atguigu.service;

import com.atguigu.bean.Cart;
import com.atguigu.bean.User;

public interface OrderService {
    public String createOrder(Cart cart, User user);
}
