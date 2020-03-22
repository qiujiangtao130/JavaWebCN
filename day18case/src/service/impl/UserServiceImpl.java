package service.impl;

import dao.UserDao;
import dao.imp.UserDaoImpl;
import domain.PageBean;
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
//        if(user.getName()==null || !user.getName().matches("^[a-zA-Z0-9_-]{4,16}$")){
//            return false;
//        }
//        if(user.getEmail() == null || !user.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
//            return false;
//        }


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

    @Override
    public User findUserById(Integer id) {
        if(id==null || id<0){
            return null;
        }
        return userDao.findUserById(id);

    }

    @Override
    public void updateUser(User user) {
        //姓名不用判断, 判断 qq号,email
        if(user.getEmail() == null || !user.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            return;
        }
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        for (String s: ids
             ) {
            userDao.deleteUser(Integer.parseInt(s));
        }
    }

    @Override
    public PageBean findUserByPage(int currentPage, int rows) {
        PageBean<User> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount=userDao.findTotalCount();
        pb.setTotalCount(totalCount);
        //每页开头
        int start=(currentPage-1)*rows;
        List<User> list=userDao.findByPage(start,rows);
        pb.setList(list);
        //总页码
        int totalPage = totalCount%rows  == 0? totalCount/rows :totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public int findTotalPage(int rows) {

        return userDao.findTotalCount()%rows==0?userDao.findTotalCount()/rows :userDao.findTotalCount()/rows+1;
    }


}
