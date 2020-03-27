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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("checkCode");
        String ansCode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        Result result=new Result();
        ObjectMapper objectMapper = new ObjectMapper();
        if(code==null || "".equals(code) ||!ansCode.equalsIgnoreCase(code)){
            result.setFlag(false);
            result.setMsg("验证码错误");
            objectMapper.writeValue(response.getWriter(),result);
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
         User user = userService.login(username,password);
         if(user==null){
             result=new Result(false,"用户名密码错误");
             objectMapper.writeValue(response.getWriter(),result);
         }else{
             request.getSession().setAttribute("user",user);
             result=new Result(true,"登陆成功");
             objectMapper.writeValue(response.getWriter(),result);
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
