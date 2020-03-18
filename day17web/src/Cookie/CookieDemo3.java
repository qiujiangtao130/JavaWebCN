package Cookie;

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
//@WebServlet("/CookieDemo3")
//public class CookieDemo3 extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            //获取所有的cookie
//        Cookie[] cookies = request.getCookies();
//        response.setContentType("text/html;charset=utf-8");
//        boolean flag = false;
//        if(cookies!=null && cookies.length>0){
//            for (Cookie c: cookies
//                 ) {
//                String name =c.getName();
//                if("lastTime".equals(name)){
//                    flag=true;
//                    Date date = new Date();
//                    SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd天 HH:mm:ss");
//                    String str_date=sdf.format(date);
//                    System.out.println("编码前:"+str_date);
//                    //URL编码
//                    str_date=URLEncoder.encode(str_date,"utf-8");
//                    System.out.println("编码后:"+str_date);
//
//                    c.setValue(str_date);
//                   c.setMaxAge(60*24*60*30);
//                    //c.setMaxAge(0);
//                    response.addCookie(c);
//
//                    //响应数据获取cookie的value
//                    String value = c.getValue();
//                    //URL解码
//                    System.out.println("解码前:"+value);
//                    value= URLDecoder.decode(value,"utf-8");
//                    System.out.println("解码后:"+value);
//                    response.getWriter().write("<h1>欢迎回来,您上次访问时间:"+value+"</h>");
//                    break;
//                }
//
//            }
//        }
//        if(cookies==null || cookies.length==0 || flag==false){
//            //没有, 第一次访问
//            Date date = new Date();
//            SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd天 HH:mm:ss");
//            String str_date=sdf.format(date);
//            System.out.println("首次登录编码前:"+str_date);
//            str_date=URLEncoder.encode(str_date,"utf-8");
//            System.out.println("首次登录编码后:"+str_date);
//            Cookie cookie=new Cookie("lastTime",str_date);
//            cookie.setMaxAge(60*24*60*30);
//            response.addCookie(cookie);
//            response.getWriter().write("<h1>欢迎首次登陆!!!!!!!!</h1>");
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//}
