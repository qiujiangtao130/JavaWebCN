package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userService=new UserServiceImpl();
       String currentPage =request.getParameter("currentPage");
        String  rows = request.getParameter("rows");
        if (currentPage==null||"".equals(currentPage) ){
            currentPage="1";
        }
        if (rows==null||"".equals(rows)){
            rows="5";
        }
        if(Integer.parseInt(currentPage)<=0){
            currentPage="1";
        }
       int totalPage = userService.findTotalPage(Integer.parseInt(rows));
        //System.out.println(totalPage+"------");
        if(Integer.parseInt(currentPage)>totalPage){
            currentPage=totalPage+"";
        }

        PageBean pb = userService.findUserByPage(Integer.parseInt(currentPage),Integer.parseInt(rows));


        //System.out.println(pb.toString());
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
