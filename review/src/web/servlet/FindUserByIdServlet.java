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

@WebServlet("/findUserByIdServlet")
public class FindUserByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("uid");
        UserService userService = new UserServiceImpl();
        User user=userService.findUserById(id);
        Result result=null;
        if(user!=null){
            result = new Result(true,"查询成功",user);
        }else{
            result = new Result(false,"没有查询到结果");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(),result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
