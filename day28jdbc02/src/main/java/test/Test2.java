package test;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        List<User> allUsers = userDao.getAllUsers();
        allUsers.forEach(System.out::println);
        User user = new User("caiji","67855","caiji@guigu.com");
        System.out.println(userDao.insertUser(user));
        allUsers = userDao.getAllUsers();
        for (User u : allUsers) {
            System.out.println(u);
        }
    }
}
