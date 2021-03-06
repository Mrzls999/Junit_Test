package javaWeb.shop.web;

import javaWeb.shop.entity.User;
import javaWeb.shop.service.UserService;
import javaWeb.shop.service.impl.UserServiceImpl;

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
        Class<User> aClass = null;
        try {
            aClass = (Class<User>) Class.forName("javaWeb.shop.entity.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserService shop_loginService = new UserServiceImpl();
        String sql = "select * from t_users where username = '" + username + "' and password = md5(" + password+");";
        User user = shop_loginService.getUserFrom_UserNameAndPassWord(sql, aClass);
        if(user!=null){//如果查到了，则
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/login_success.html");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/shop/pages/user/login.jsp").forward(request,response);
        }
    }
}
