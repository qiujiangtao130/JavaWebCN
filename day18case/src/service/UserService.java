package service;

import domain.User;

import java.util.List;

public interface UserService {
    //返回所有用户信息
    public List<User> findAll();


    public User login(User user);
}
