package WebServlet;

import CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("success");
        Cookie index = CookieUtils.findAllCookies(request.getCookies(),"index");
        Cookie ld=CookieUtils.findAllCookies(request.getCookies(),"lastTime");
        if (index==null){
            response.setContentType("text/html;charset=utf-8");
            index=new Cookie("index","1");
            response.getWriter().write("<h1>你是第"+index.getValue()+"个登录的用户</h1>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
            Date date = new Date();
            ld= new Cookie("lastTime",sdf.format(date));
            index.setMaxAge(3600*24*30);
            ld.setMaxAge(3600*24*30);
            response.addCookie(index);
            response.addCookie(ld);
        }else {
            response.setContentType("text/html;charset=utf-8");
            int ind= Integer.valueOf(index.getValue());
            ind++;
            index.setValue(ind+"");
            response.getWriter().write("<h1>你是第"+index.getValue()+"个登录的用户</h1>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
            Date date = new Date();
            response.getWriter().write("<h2>你上次登录时间是"+ld.getValue()+"</h2>");
            ld.setValue(sdf.format(date));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
