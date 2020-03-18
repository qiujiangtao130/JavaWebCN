package Cookie;

//import CookieUtils.CookieUtils;
//
//import javax.servlet.Servlet;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@WebServlet("/CookieDemo4")
//public class CookieDemo4 extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        response.setContentType("text/heml;charset=utf-8");
//        Cookie cookie = CookieUtils.findAllCookies(cookies, "lastTime");
//        if (cookie != null) {
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//            String value = sdf.format(date);
//            value = URLEncoder.encode(value, "utf-8");
//            cookie.setValue(value);
//            cookie.setMaxAge(60 * 60 * 24 * 30);
//            response.addCookie(cookie);
//            value=cookie.getValue();
//            value= URLDecoder.decode(value,"utf-8");
//            response.getWriter().write("<h1>欢迎再次光临,上次登陆时间是:"+value+"</h>");
//
//        }else{
//            Date date = new Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//            String value = sdf.format(date);
//            value = URLEncoder.encode(value, "utf-8");
//            cookie=new Cookie("lastTime",value);
//            cookie.setMaxAge(60 * 60 * 24 * 30);
//            response.addCookie(cookie);
//            value=cookie.getValue();
//            value= URLDecoder.decode(value,"utf-8");
//            System.out.println("首次访问"+value);
//            response.getWriter().write("<h1>欢迎第一次光临:</h>");
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
