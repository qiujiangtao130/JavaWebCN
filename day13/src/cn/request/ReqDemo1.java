package cn.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ReqDemo1")
public class ReqDemo1 extends HttpServlet {
    //演示request
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method= req.getMethod();
        System.out.println(method+", ");

        String  contextPath=req.getContextPath();
        System.out.println(contextPath+", ");

        String servletPath=req.getServletPath();
        System.out.println(servletPath+", ");

        String queryString = req.getQueryString(); //请求参数
        System.out.println(queryString+", ");
        //uri > url  权限校验的时候要知道 访问的资源是什么
        String requestURI = req.getRequestURI();
        System.out.println(requestURI+", ");

        String protocol = req.getProtocol();
        System.out.println(protocol+", ");
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr+", ");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
