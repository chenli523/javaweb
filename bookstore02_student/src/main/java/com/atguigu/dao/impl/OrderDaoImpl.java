package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int insert(Order order) {
        String sql = "insert into orders values(?, ?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getOrderDate(), order.getTotalCount(), order.getTotalAmount(), order.getOrderState(), order.getUserId());
    }
}
