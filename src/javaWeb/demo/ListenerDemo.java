package javaWeb.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听ServletContext对象的创建与销毁
 */
public class ListenerDemo implements ServletContextListener {

    //ServletContext创建时调用
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext created……");
    }

    //ServletContext销毁时调用
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext destroyed……");
    }
}
