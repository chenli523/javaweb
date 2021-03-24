package com.atguigu.bean;

public class User {
    private int id;
    private String userName;
    private String passwd;
    public User() {
    }
    public User(int id, String userName, String passwd) {
        this.id = id;
        this.userName = userName;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPasswd() {
        return passwd;
    }

    public User setPasswd(String passwd) {
        this.passwd = passwd;
        return this;
    }
}
