package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private   UserDao userDao=new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean delUser(Integer id) {
        return userDao.delUser(id);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findUserByInfo(User user) {
        return userDao.findUserByInfo(user);
    }
}
