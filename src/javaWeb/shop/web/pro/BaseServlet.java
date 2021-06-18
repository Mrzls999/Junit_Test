package javaWeb.shop.web.pro;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    /**
     * 每次创建对象都会调用service方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post提交方式设置支持中文
        req.setCharacterEncoding("utf-8");//设置请求体编码
        resp.setHeader("Content-Type","text/html;charset=utf-8");//设置浏览器编码
        resp.setCharacterEncoding("utf-8");//设置response的编码

        String methodName = req.getParameter("meth");//得到从url串中填写好的方法名字
        Class<? extends BaseServlet> aClass = this.getClass();//得到运行类
        try {
            Method method = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);//根据方法名字得到方法
            method.invoke(aClass.newInstance(),req,resp);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
