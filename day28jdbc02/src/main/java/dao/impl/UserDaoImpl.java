package dao.impl;

import bean.User;
import dao.DbUtilsBaseDao;
import dao.UserDao;

import java.util.List;

public class UserDaoImpl extends DbUtilsBaseDao<User> implements UserDao {

    @Override
    public List<User> getAllUsers() {
        String sql = "select id, user_name as username, password, email from users";
        return getBeanList(User.class, sql);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return update("insert into users values(null, ?, ?, ?)",user.getUsername(), user.getPassword(), user.getEmail());
    }


}
