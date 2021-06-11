package javaWeb.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletConfig_Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String pageNum1 = this.getServletConfig().getInitParameter("pageNum");
        String pageNum = this.getInitParameter("pageNum");
        System.out.println(pageNum);
    }
}
