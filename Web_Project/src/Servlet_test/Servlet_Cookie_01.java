package Servlet_test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet_Cookie_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取请求头信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //创建cookie
        Cookie cookie1 = new Cookie("username",username);
        Cookie cookie2 = new Cookie("password",password);
        //写入cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        //通知服务器将获取的内容写入响应体中交给浏览器(请求转发)
        request.getRequestDispatcher("/Cookie_test2.html").forward(request, response);





    }
}
