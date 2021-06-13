package javaWeb.shop.web;

import javaWeb.shop.entity.UserLogin;
import javaWeb.shop.service.Shop_LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Shop_LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Class<UserLogin> aClass = null;
        try {
            aClass = (Class<UserLogin>) Class.forName("javaWeb.shop.entity.UserLogin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Shop_LoginService shop_loginService = new Shop_LoginService();
        String sql = "select * from user_login where username = '" + username + "' and password = md5(" + password+");";
        boolean flag = shop_loginService.getUserFrom_UserNameAndPassWord(sql, aClass);
        System.out.println(flag);

    }
}
