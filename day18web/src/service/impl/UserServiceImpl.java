package service.impl;

import dao.UserDao;
import dao.imp.UserDaoImpl;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private  UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
