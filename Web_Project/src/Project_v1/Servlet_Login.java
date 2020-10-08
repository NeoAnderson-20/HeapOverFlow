package Project_v1;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Servlet_Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password;
        request.setCharacterEncoding("utf-8");
        username = request.getParameter("username");
        password = request.getParameter("password");
        int resualt = 0;
        UserDao dao = new UserDao();
        try {
            resualt = dao.login(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(resualt == 1){
            HttpSession httpSession = request.getSession();
            response.sendRedirect("/myweb/Welcome.html");
        }else {
            response.sendRedirect("/myweb/login_error.html");

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向到该网页或另一个Servlet
//        response.sendRedirect("/myweb/index.html");
    }
}
