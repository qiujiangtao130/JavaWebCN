package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/csTest1")
public class csTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context= request.getServletContext();
        String filename="a.jpg";
        ClassLoader cl = this.getClass().getClassLoader();

        System.out.println(context.getMimeType(filename));
        System.out.println("sc---"+context.getRealPath("/WEB-INF/classes/ServletContext/a.txt"));
        System.out.println("cl----"+cl.getResource("/ServletContext/a.txt").getPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
