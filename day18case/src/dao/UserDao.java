package dao;

import domain.User;

import java.util.List;
import java.util.Map;

//操作数据库的接口
public interface UserDao {
    public List<User> findAll();

    public User login(String username, String password);

    public void addUser(User user);

    public void deleteUser(int i);

    public User findUserById(Integer id);

    void updateUser(User user);


    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
