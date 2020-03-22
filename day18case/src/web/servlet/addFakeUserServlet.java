package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/addFakeUserServlet")
public class addFakeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        for (int i = 0; i <10 ; i++) {
            User user =new User();
            user.setName("机器人"+i);
            user.setAge(10+i);
            user.setAddress("上海");
            user.setGender("男");
            user.setQq("000000"+i);
            user.setEmail(i+"asdfasdf@123.com");
            UserService userService= new UserServiceImpl();
            userService.addUser(user);
        }
        response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
