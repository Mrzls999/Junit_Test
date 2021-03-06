package javaWeb.shop.web;

import javaWeb.shop.entity.User;
import javaWeb.shop.service.UserService;
import javaWeb.shop.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

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
        UserService shop_registerService = new UserServiceImpl();
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO t_users(username,password,email) VALUES('"+ user.getUsername()+"','"+ user.getPassword()+"','"+ user.getEmail()+"')";
        Boolean flag = shop_registerService.ShopRegister_By_UserNamePasswordEmail(sql);
        if(flag){//如果注册成功，则
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/regist_success.html");
        }else {
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/regist.html");
        }
    }
}
