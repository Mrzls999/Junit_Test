package javaWeb.shop.web.pro;

import javaWeb.shop.entity.UserLogin;
import javaWeb.shop.service.UserService;
import javaWeb.shop.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends Base_UserServlet {

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        UserLogin userLogin = new UserLogin();
        try {
            BeanUtils.populate(userLogin,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class<UserLogin> aClass = null;
        try {
            aClass = (Class<UserLogin>) Class.forName("javaWeb.shop.entity.UserLogin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserService shop_loginService = new UserServiceImpl();
        String sql = "select * from user_login " +
                     "where username = '" + userLogin.getUsername() + "' and password = md5(" + userLogin.getPassword()+");";
        boolean flag = shop_loginService.getUserFrom_UserNameAndPassWord(sql, aClass);
        if(flag){//如果查到了，则
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/login_success.html");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("/shop/pages/user/login.jsp").forward(request,response);
        }
    }

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UserService shop_registerService = new UserServiceImpl();
        UserLogin userLogin = new UserLogin();
        try {
            BeanUtils.populate(userLogin,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO user_login(username,password,email) VALUES('"+userLogin.getUsername()+"','"+userLogin.getPassword()+"','"+userLogin.getEmail()+"')";
        Boolean flag = new UserServiceImpl().ShopRegister_By_UserNamePasswordEmail(sql);
        if(flag){//如果注册成功，则
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/regist_success.html");
        }else {
            response.sendRedirect(request.getContextPath()+"/shop/pages/user/regist.html");
        }
    }
}
