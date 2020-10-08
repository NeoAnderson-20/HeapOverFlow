package Servlet_test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet_Cookie_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int X = 10;
        int Y = 20;
        String username;
        //读取请求头信息
        String s = request.getParameter("x");
        //读取cookie
        Cookie[] cookies = request.getCookies();

        for (Cookie i : cookies) {
            String key = i.getName();
            String value = i.getValue();

            if ("username".equals(key)) {

                // .....
            }
        }
    }

}
