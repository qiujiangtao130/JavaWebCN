package dao.imp;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
//        System.out.println(sb.toString());
//        System.out.println(params);

        return jdbcTemplate.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user  where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
//        System.out.println(sql);
//        System.out.println(params);

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}
