package Servlet_test;

import jdk.jfr.ContentType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet_04 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int m = 50;
        response.setContentType("text/html;charset = utf-8");
        PrintWriter out = response.getWriter();
//
//        out.write(97);
        out.println("</br>ok");
        out.println(m);
        out.println("</br>qwrqwr</br>qwrqwr</br>qwr");
        out.println("加油</br>加油</br>qwr");
//        response.sendRedirect("http://www.google.com");

    }


}
