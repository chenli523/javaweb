package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDao {
    public User getUser(User user);
    public User checkUserName(String username);
    public int saveUser(User user);
//    public List<User> getUsers(User user);
}
