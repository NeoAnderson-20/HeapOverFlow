package Project_v1;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Servlet_UserDel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");         //这行要放在开头
        String username;
        UserDao dao = new UserDao();
        int result = 0;
        PrintWriter out = response.getWriter();
        username = request.getParameter("username");
        out.print(username+"   ");
        try {
            result = dao.delete(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(result == 0){
            out.print("Delete!");
        }else{
            out.print("Failed!");
        }

    }
}
