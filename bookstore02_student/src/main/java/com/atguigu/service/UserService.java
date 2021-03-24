package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
    public User getUser(User user);
    public User checkUserName(String lastName);
    public int saveUser(User user);
}
