package test;

import Dao.UserDao;
import Domain.User;
import org.junit.Test;

public class UserDamTest {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUserName("abc");
        loginuser.setPASSWORD("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
