package web.servlet;

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
import java.util.Map;



@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //System.out.println("addUserServlet");
        User user=new User();
        Map<String, String[]> userMap = request.getParameterMap();
        UserService userService = new UserServiceImpl();
        try{
            BeanUtils.populate(user,userMap);
            //System.out.println(user.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        boolean b = userService.addUser(user);

        //添加成功则跳转回listServlet
        if(b){
            response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
        }else{
            request.setAttribute("msg_add","添加失败");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
