package cn.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReqDemo2")
public class ReqDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如果要获取 request 里有中文 要使用setcharacterEncoding -- utf-8
        request.setCharacterEncoding("utf-8");
        String agent = request.getHeader("user-agetn");
        if(agent.contains("Chrome")){
            System.out.println("chrome 来了");
        }
    }
}
