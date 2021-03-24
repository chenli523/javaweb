package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User getUser(User user) {
        String sql = "select id_user as id, username, user_password as password, user_email as email from users where username=? and user_password=?";
        return getBean(User.class, sql, user.getUsername(),user.getPassword());
    }

    @Override
    public User checkUserName(String username) {
        String sql = "select id_user as id, username, user_password as password, user_email as email from users where username=?";
        return getBean(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into users values(null, ?, ?, ?, ?, ?)";
        return update(sql, user.getUsername(), user.getFirstname(), user.getLastname(), user.getPassword(), user.getEmail());
    }

//    @Override
//    public List<User> getUsers(User user) {
//        String sql = "select id_user, user_lastname, user_firstname, user_password, user_email from users where user_lastname = ? and password = ?";
//        return getBeanList(User.class, sql, user);
//    }

}
