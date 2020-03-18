package LoginServlet;

import CookieUtils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code= request.getParameter("checkcode");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        //System.out.println(name+" "+password);
        response.setContentType("text/html;charset=utf-8");
        //response.getWriter().write(name+" "+password);
        //取得session对象
        HttpSession session=request.getSession();
        String codeSession = (String)session.getAttribute("codeSession");
        //System.out.println(codeSession);
        if(codeSession!=null &&codeSession.equalsIgnoreCase(code)){
            if("abc".equals(name) && "123".equals(password)){
                //request.getRequestDispatcher("/SuccessServlet").forward(request,response);
                Cookie index = CookieUtils.findAllCookies(request.getCookies(),"index");
                Cookie ld=CookieUtils.findAllCookies(request.getCookies(),"lastTime");
                //index==null 第一次登录
                if (index==null){
                    response.setContentType("text/html;charset=utf-8");
                    index=new Cookie("index","1");
                    session.setAttribute("index","你是第"+index.getValue()+"个登录的用户");
                   // response.getWriter().write("<h1>你是第"+index.getValue()+"个登录的用户</h1>");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                    Date date = new Date();
                    ld= new Cookie("lastTime",sdf.format(date));
                    session.setAttribute("lastTime",ld);
                    index.setMaxAge(3600*24*30);
                    ld.setMaxAge(3600*24*30);
                    response.addCookie(index);
                    response.addCookie(ld);
                }else {
                    response.setContentType("text/html;charset=utf-8");
                    //第几个登录
                    int ind= Integer.valueOf(index.getValue());
                    ind++;
                    index.setValue(ind+"");
                    //response.getWriter().write("<h1>你是第"+index.getValue()+"个登录的用户</h1>");
                    session.setAttribute("index","你是第"+ind+"个登录的用户");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                    Date date = new Date();
                    //response.getWriter().write("<h2>你上次登录时间是"+ld.getValue()+"</h2>");
                    session.setAttribute("lastTime","你上次登录时间是"+ld.getValue());
                    ld.setValue(sdf.format(date));
                    response.addCookie(index);
                    response.addCookie(ld);
                }
            response.sendRedirect("/day17web/success.jsp");

            }else{
                response.sendRedirect("/day17web/login.jsp?error=y2");
            }
        }else {
            response.sendRedirect("/day17web/login.jsp?error=y");

        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
