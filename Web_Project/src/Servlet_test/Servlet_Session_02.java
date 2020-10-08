package Servlet_test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Servlet_Session_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Enumeration goodnames = session.getAttributeNames();
        PrintWriter out = response.getWriter();

        while (goodnames.hasMoreElements()){
            String goodname = (String)goodnames.nextElement();
            Integer num = (Integer)session.getAttribute(goodname);
            out.println(goodname+":"+num);
        }
    }
}
