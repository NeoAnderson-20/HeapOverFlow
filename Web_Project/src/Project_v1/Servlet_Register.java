package Project_v1;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Servlet_Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        int result = 0;
        UserDao dao = new UserDao();
        User user = new User(username, password);
        try {
            result = dao.add(user,request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(result == 1){
            out.print("注册成功");
        }else {
            out.print("注册失败");
        }

    }
}
