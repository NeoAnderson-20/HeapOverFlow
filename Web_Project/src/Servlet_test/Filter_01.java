package Servlet_test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter_01 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        //拦截后索要HttpSession
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession(false);
        HttpServletResponse response = (HttpServletResponse)resp;
        if(session == null){         //如果为空,则导航到ERROR页面
            request.getRequestDispatcher("/login_error.html").forward(req, resp);
            return;
        }else {             //放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
