package service;

import domain.User;

import java.util.List;

public interface UserService {
    //返回所有用户信息
    public List<User> findAll();


    public User login(User user);

    public boolean addUser(User user);

    public void deleteUser(String id);

    public User findUserById(Integer id);

    void updateUser(User user);
}
