package Dao;

import Domain.User;
import Utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class UserDao {
    //数据库里有几个表就有几个Dao包-- Dao处理数据库
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){


        //loginUser.getUserName 对应的是 sql里的 ? 同理 password
        try {
            String sql = "select * from user where username= ? and PASSWORD = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),loginUser.getUserName(),loginUser.getPASSWORD());
            return user;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
