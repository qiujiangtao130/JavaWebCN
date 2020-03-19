package dao;

import domain.User;

import java.util.List;
//操作数据库的接口
public interface UserDao {
    public List<User> findAll();
}
