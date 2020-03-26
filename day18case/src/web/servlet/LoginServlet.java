package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("utf-8");
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();

        //判断session域里的验证码与用户输入验证码一致
        String checkCodeSession = (String) session.getAttribute("verifycode");
        session.removeAttribute("verifycode");
        if (checkCodeSession.equalsIgnoreCase(verifycode)) {
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                UserService service = new UserServiceImpl();
                User loginUser = service.login(user);
                if (loginUser != null) {
                    //成功
                    session.setAttribute("user", loginUser);
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                } else {
                    //登陆失败 用户名 或密码错误
                    request.setAttribute("login_msg", "用户名密码错误错误!!!!!!!");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);

                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("login_msg", "验证码错误!!!!!!!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
