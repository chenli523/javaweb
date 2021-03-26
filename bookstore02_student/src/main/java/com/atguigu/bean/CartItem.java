package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;

//业务bean
public class CartItem implements Serializable {
    private static final long serialVersionUID = -5773970109691646628L;
    private Book book;
    private int count;
    private double amount;

    public CartItem() {
    }

    public CartItem(Book book, int count, double amount) {
        this.book = book;
        this.count = count;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", amount=" + amount +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        BigDecimal price = new BigDecimal(book.getPrice()+"");
        BigDecimal c = new BigDecimal(count+"");
//        System.out.println(price.multiply(c).doubleValue());
        return price.multiply(c).doubleValue();
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
