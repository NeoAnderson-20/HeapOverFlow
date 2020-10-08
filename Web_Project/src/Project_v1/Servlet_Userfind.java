package Project_v1;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class Servlet_Userfind extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        response.setContentType("text/html;charset=utf-8");         //这行要放在开头


        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            response.sendRedirect("/myweb/login_error.html");
            return;
        }


        List<User> userList = null;
        try {
            userList = dao.findall();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        PrintWriter out = response.getWriter();

        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>Username:</td>");
        out.print("<td>password:</td>");
        out.print("<td>option:</td>");
        out.print("</tr>");


        for (User o : userList) {
            out.print("<tr>");
            out.print("<td>" + o.getUsername() + "</td>");
            out.print("<td>" + o.getPassword() + "</td>");
            out.print("<td><a href ='/myweb/userdel?username="+o.getUsername()+"'>Del</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
