package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Cart implements Serializable {
    private static final long serialVersionUID = 6804672413916822529L;
    // cartitem map
    private Map<String, CartItem> map = new LinkedHashMap<>();
    private int totalCount;
    private double totalAmount;

    public Cart() {
    }

    public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
        this.map = map;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
    }

    // amount accurate problem solutions
    // 1.avoiding the problem in the design period
    // 1 dollar = 100 cents
    // 2.using BigDecimal

    public List<CartItem> getCartItems() {
        Collection<CartItem> values = map.values();
        return new ArrayList<>(values);
    }

    //adding items
    // 1. add book to cartItem
    // count: default 1
    // amount: cal
    // 2. add cart item to the map
    public void addItem(Book book) {
        CartItem cartItem = map.get(book.getId()+"");
        // havent added book
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(1);
//            cartItem.setAmount(book.getPrice());
            map.put(book.getId()+"", cartItem);
        } else {// have added
            int newCount = cartItem.getCount() + 1;
            cartItem.setCount(newCount);
//            cartItem.setAmount(cartItem.getAmount());
        }
    }

    public void deleteItem(String bookId) {
        map.remove(bookId);
    }

    public void clearCart() {
        map.clear();
    }

    public void updateItemCount(String bookId, String count) {
        CartItem cartItem = map.get(bookId);
        try {
            // havent added book
            if (cartItem != null) {
                if ("".equals(count)) {
                    count = "1";
                }
                count = count.trim();
                cartItem.setCount(Integer.parseInt(count));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", totalCount=" + totalCount +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public int getTotalCount() {
        int totalCount = 0;
        BigDecimal totalAmount = new BigDecimal("0");
        for (CartItem cartItem : getCartItems()) {
            totalCount += cartItem.getCount();
            totalAmount = totalAmount.add(new BigDecimal(cartItem.getAmount() + ""));
        }
        this.totalAmount = totalAmount.doubleValue();
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalAmount() {
//        BigDecimal totalAmount = new BigDecimal("0");
//        for (CartItem cartItem : getCartItems()) {
//            totalAmount = totalAmount.add(new BigDecimal(cartItem.getAmount() + ""));
//        }
//        return totalAmount.doubleValue();
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
