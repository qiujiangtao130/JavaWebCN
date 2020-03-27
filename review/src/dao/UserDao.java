package dao;

import domain.User;

public interface UserDao {
    User login(String username, String password);
}
