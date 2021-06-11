package javaWeb.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContext_Test2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获取通过继承HttpServlet创建的域对象
        Object name = servletContext.getAttribute("name");
        System.out.println(name);
        //获取通过继承GenericServlet创建的域对象
        Object password = servletContext.getAttribute("password");
        System.out.println(password);
    }
}
