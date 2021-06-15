package javaWeb.shop.web;

import javaWeb.shop.service.Shop_RegisterService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Shop_RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop_RegisterService shop_registerService = new Shop_RegisterService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sql = "INSERT INTO user_login(username,password,email) VALUES('"+username+"','"+password+"','"+email+"')";
        Boolean flag = shop_registerService.ShopRegister_By_UserNamePasswordEmail(sql);
        System.out.println("是否注册成功"+flag);
    }
}
