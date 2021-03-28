package com.atguigu.dao.impl;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

public class OrderItemImpl extends BaseDao<OrderItem> implements OrderItemDao{
    @Override
    public int insert(OrderItem orderItem) {
        String sql = "insert into order_detail values(?, ?, ?, ?, ?, ?, ?, ?)";
        return update(sql,
                null,
                orderItem.getCount(),
                orderItem.getAmount(),
                orderItem.getTitle(),
                orderItem.getAuthor(),
                orderItem.getPrice(),
                orderItem.getImgPath(),
                orderItem.getOrderId());
    }

    @Override
    public int[] insert(Object[][] params) {
        String sql = "insert into order_detail values(?, ?, ?, ?, ?, ?, ?, ?)";
        return updateBatch(sql, params);
    }
}
