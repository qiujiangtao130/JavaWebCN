package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Test1")
public class Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向
        System.out.println("demo1");
//        response.setStatus(302);
//        response.setHeader("location","/day15web/Test2");
        //sendRedirect 方法等价上面两个方法.
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("跳转中至test2");
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/Test2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
