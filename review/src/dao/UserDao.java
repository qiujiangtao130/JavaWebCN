package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    User login(String username, String password);

    List<User> findAll();

    boolean delUser(Integer id);

    User findUserById(String id);

    boolean updateUser(User user);

    boolean addUser(User user);

    List<User> findUserByInfo(User user);
}
