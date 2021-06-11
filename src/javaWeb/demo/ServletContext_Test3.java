package javaWeb.demo;

import javax.servlet.*;
import java.io.IOException;

public class ServletContext_Test3 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获取通过继承HttpServlet创建的共享对象
        Object name = servletContext.getAttribute("name");
        System.out.println(name);
        //创建通过继承GenericServlet创建的共享对象
        servletContext.setAttribute("password","love");
    }
}
