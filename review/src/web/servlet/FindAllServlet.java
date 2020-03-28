package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Result;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> users= userService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        Result result=null;
        if(users!=null ) {
            result=new Result(true,"加载用户数据成功",users);
            objectMapper.writeValue(response.getWriter(), result);
        }else{
            result=new Result(false,"加载用户数据失败");
            objectMapper.writeValue(response.getWriter(), result);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
