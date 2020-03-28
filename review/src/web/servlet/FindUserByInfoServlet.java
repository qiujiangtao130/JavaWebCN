package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Result;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findUserByInfoServlet")
public class FindUserByInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try{
            BeanUtils.populate(user,parameterMap);
            System.out.println("要查询的:"+user.toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        List<User> users = userService.findUserByInfo(user);
        for (User u: users
             ) {
            System.out.println(u.toString());
        }
        Result result=null;
        if(users.isEmpty()){
            result=new Result(false,"没有查询到结果");
        }else {
            result=new Result(true,"查询成功",users);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getWriter(), result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
