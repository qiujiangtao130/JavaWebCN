package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/d4","/dd4"})//多个访问路径 urlpartten 有三种
public class Demo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo4 doget");
        System.out.println(req);
    }
//    请求消息的格式
    // http协议有7中 一般是get和 post
    //get: 在请求头中
    //post: 在请求体中
//    反应消息的格式
//
}
