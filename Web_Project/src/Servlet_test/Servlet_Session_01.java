package Servlet_test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Servlet_Session_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodname = request.getParameter("goodname");
        HttpSession session = request.getSession();
        Integer num = (Integer)session.getAttribute(goodname);
        if(num == null){
            session.setAttribute(goodname, 1);
        }else {
            session.setAttribute(goodname, num+1);
        }
        response.sendRedirect("/myweb/shopping.html");












        //设置和获取HttpSession的方法

        //        HttpSession session = request.getSession();
//        session.setAttribute("k1", 123);


        //另一个servlet获取session
//        HttpSession session = request.getSession();
//        session.getAttribute("k1");
    }
}
