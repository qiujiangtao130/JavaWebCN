package Web;

import Dao.UserDao;
import Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

      String username=req.getParameter("username");
        String password=req.getParameter("password");
        //封装user对象
        User loginUser = new User();
        loginUser.setUserName(username);
        loginUser.setPASSWORD(password);
        //Map<String,String[]>
        UserDao dao=new UserDao();
        User user = dao.login(loginUser);
        if(user==null){
            //登录失败 转到另一个资源-> FailLogin
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            //登录成功 存储数据 并转发到successServlet
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
