package dao.impl;

import Utils.JDBCUtils;
import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login(String username, String password) {
        String sql = "select * from m_user where username = ? and password = ?";
        try {
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, password);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from m_user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public boolean delUser(Integer id) {
        String sql = "delete from m_user where id = ?";
        int i = template.update(sql, id);
        System.out.println(i);
        return true;
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from m_user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update m_user set username = ?, password = ?,address = ?, telephone = ?, remake = ?, department = ? where id = ?";
        int i = template.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                user.getTelephone(), user.getRemake(), user.getDepartment(), user.getId());
        if (i > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean addUser(User user) {
        String sql="insert into m_user values (?,?,?,?,?,?,?)";
        int i =template.update(sql,null, user.getUsername(), user.getPassword(), user.getAddress(),
                user.getTelephone(), user.getRemake(), user.getDepartment());
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> findUserByInfo(User user) {
        String sql ="select * from m_user where 1+1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<Object>();
        if(user.getUsername()!=null){
            sb.append(" and username like ?");
            params.add("%"+user.getUsername()+"%");
        }
        if(user.getAddress()!=null){
            sb.append(" and address like ?");
            params.add("%"+user.getAddress()+"%");
        }
        if(user.getTelephone()!=null){
            sb.append(" and telephone like ?");
            params.add("%"+user.getTelephone()+"%");
        }
        return template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
