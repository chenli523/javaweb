package com.atguigu.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = 4627003441092683339L;
    private String orderId;
    private Date orderDate;
    private int totalCount;
    private double totalAmount;
    private int orderState;
    private int userId;

    public Order() {
    }

    public Order(String orderId, Date orderDate, int totalCount, double totalAmount, int orderState, int userId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
        this.orderState = orderState;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", totalCount=" + totalCount +
                ", totalAmount=" + totalAmount +
                ", orderState=" + orderState +
                ", userId=" + userId +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
