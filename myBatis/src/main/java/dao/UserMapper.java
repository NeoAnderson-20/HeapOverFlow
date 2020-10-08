package dao;

import myBatisTest.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
    List<User> getByname(String name);
    int addUser(User user);
    int update(User user);
    int del(String username);

}
