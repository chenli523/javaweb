package com.atguigu.dao;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {
    public int insert(OrderItem orderItem);
    public int[] insert(Object[][] orderItem);
}
