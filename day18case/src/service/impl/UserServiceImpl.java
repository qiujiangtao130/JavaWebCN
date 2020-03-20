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

    @Override
    public User login(User user) {
        return userDao.login(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean addUser(User user) {
        //校验用户输入的信息是否符合要求 前期 所有的不符合都是false 后期可以改传递错误信息回servlet层
        if(user.getName()==null || !user.getName().matches("^[a-zA-Z0-9_-]{4,16}$")){
            return false;
        }
        if(user.getEmail() == null || !user.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            return false;
        }


            userDao.addUser(user);


        return true;

    }

    @Override
    public void deleteUser(String id) {
        if(""==id ||id==null){
            return;
        }
        int i =Integer.parseInt(id);
        if(i<0){
            return;
        }
        userDao.deleteUser(i);
    }


}
