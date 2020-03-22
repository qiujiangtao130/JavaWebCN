package dao.imp;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select*from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User login(String username, String password) {
        String sql = "select*from user where username = ? and password = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, password);
            return user;
        } catch (Exception e) {
            System.out.println("用户密码有问题没有得到数据");
            return null;
        }

    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        jdbcTemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(int i) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,i);
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "select * from user where id = ?";
        User user=new User();
        try{
            user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
            //System.out.println("dao:"+user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount() {
        String sql ="select count(*) from user";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select *from user limit ?,?";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }


}
