package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Result;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("uid"));
        UserService userService = new UserServiceImpl();
        Result result=null;
        if(userService.delUser(id)) {
            result = new Result(true,"删除成功");
            ObjectMapper objectMapper= new ObjectMapper();
            objectMapper.writeValue(response.getWriter(),result);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
