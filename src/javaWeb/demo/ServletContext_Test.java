package javaWeb.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContext_Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //得到项目的上下文路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        //得到web目录下的文件的完全路径(如果你想获取源代码的路径，那么他会找到这个源代码编译好的class路径)
        String realPath = servletContext.getRealPath("/src/javaWeb/Demo/MyServlet");
        System.out.println(realPath);
        //设置共享对象key-value==>在ServletContext_Test2中获取这个值
        servletContext.setAttribute("name","zls");
    }
}
