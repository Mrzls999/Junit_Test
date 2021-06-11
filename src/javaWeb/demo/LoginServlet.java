package javaWeb.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);//注意此处的this使用，如果不加this，默认是谁调的呢？当然还是this喽
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("admin".equals(username)&&"1234".equals(password)){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }
    }
}
