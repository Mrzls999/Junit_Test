package javaWeb.shop.web.pro;

import javaWeb.shop.entity.User;
import javaWeb.shop.service.UserService;
import javaWeb.shop.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean flag = true;
        if (cookies!=null&&request.getSession().getAttribute("user")!=null) {//如果cookie不为空，则进行遍历，找到用户；并且有session域的user，这个是后期为了生成订单时使用，其实只使用这个就行
            for (Cookie cookie : cookies) {
                if("userName".equals(cookie.getName())){
                    response.sendRedirect(request.getContextPath()+"/shop/pages/user/login_success.jsp");
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {//如果没有关于用户登录的cookie信息，那么重新登录
            User userLogin = new User();
            try {
                BeanUtils.populate(userLogin,request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Class<User> aClass = null;
            try {
                aClass = (Class<User>) Class.forName("javaWeb.shop.entity.User");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            UserService shop_loginService = new UserServiceImpl();
            String sql = "select * from t_users " +
                    "where username = '" + userLogin.getUsername() + "' and password = md5(" + userLogin.getPassword()+");";
            User user = shop_loginService.getUserFrom_UserNameAndPassWord(sql, aClass);
            if(user!=null){//如果查到了，则
                Cookie cookie = new Cookie("userName",user.getUsername());
                request.getSession().setAttribute("user",user);
                cookie.setMaxAge(60*60);
                response.addCookie(cookie);
                response.sendRedirect(request.getContextPath()+"/shop/pages/user/login_success.jsp");
            }else {
                request.setAttribute("msg","用户名或密码错误");
                request.getRequestDispatcher("/shop/pages/user/login.jsp").forward(request,response);
            }
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
        User user = new User();
        String code = request.getParameter("code");//从前端获取的验证码
        String sessionCode = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");//从kaptcha获取的验证码
        if(!code.equals(sessionCode)){//如果验证码不一样，重新注册
            request.setAttribute("registerMsg","注册失败，验证码错误");
//          response.sendRedirect(request.getContextPath()+"/shop/pages/user/regist.jsp");
            request.getRequestDispatcher("/shop/pages/user/regist.jsp").forward(request,response);
        }else {//如果验证码一样
            try {
                BeanUtils.populate(user,request.getParameterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String sql = "INSERT INTO user_login(username,password,email) VALUES('"+ user.getUsername()+"',md5('"+ user.getPassword()+"'),'"+ user.getEmail()+"')";
            Boolean flag = new UserServiceImpl().ShopRegister_By_UserNamePasswordEmail(sql);
            if(flag){//如果注册成功，则
                response.sendRedirect(request.getContextPath()+"/shop/pages/user/login.jsp");
            }else {
                request.setAttribute("registerMsg","注册失败");
                request.getRequestDispatcher("/shop/pages/user/regist.jsp").forward(request,response);
            }
        }
    }

    /**
     * 用户注销
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        request.getSession().removeAttribute("user");//移除session域的用户信息
        for (Cookie cookie : cookies) {
            if("userName".equals(cookie.getName())){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        response.sendRedirect(request.getContextPath()+"/shop/index.jsp");
    }
}
