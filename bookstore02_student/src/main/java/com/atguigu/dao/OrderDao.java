package com.atguigu.dao;

import com.atguigu.bean.Order;

public interface OrderDao {
    // insert into orders(?, ?, ? )
    public int insert(Order order);

}
