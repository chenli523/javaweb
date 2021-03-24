package dao;

import bean.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public int insertUser(User user);
}
