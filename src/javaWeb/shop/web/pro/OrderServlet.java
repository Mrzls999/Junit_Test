package javaWeb.shop.web.pro;

import com.alibaba.druid.util.StringUtils;
import javaWeb.shop.entity.*;
import javaWeb.shop.service.OrderService;
import javaWeb.shop.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    /**
     * 创建订单方法
     */
    protected void createOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //查看是否登录，没有登录的话，先登录
        User user = (User) request.getSession().getAttribute("user");//获取用户
        if (user == null) {//如果没有用户，则需要登录
            request.setAttribute("msg", "结账需要登录");
            request.getRequestDispatcher("/shop/pages/user/login.jsp").forward(request, response);
        } else {
            //如果登录了，看看购物车中是否有订单项，没有的话让他先添加购物车
            Cart cart = (Cart) request.getSession().getAttribute("cart");//获取购物车中的订单项
            if (cart == null) {//购物车中没有数据，提示添加商品到购物车
                request.setAttribute("msg", "请添加商品后再进行结账");
                request.getRequestDispatcher("/shop/pages/cart/cart.jsp").forward(request, response);
            } else {
                Orders orders = new Orders();//生成订单对象
                orders.setTotalPrice(cart.getTotalAmount());//设置总金额
                String oid = String.valueOf(UUID.randomUUID()).replaceAll("-", "");
                orders.setOid(oid);//设置订单Id
                orders.setOrdersTime(new Date());//设置下单时间
                orders.setState(1);//设置订单状态
                orders.setUser(user);//设置订单所属用户
                for (CartItem cartItem : cart.getAllCartItems()) {//如果购物车中有数据，则循环遍历购物车中的购物项，并添加到Order实体类
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(orders);//订单项所属订单
                    String oid1 = UUID.randomUUID().toString().replaceAll("-", "");
                    orderItem.setItemId(oid1);//订单项ID
                    orderItem.setAmount(cartItem.getPurchaseAmount());//购买金额
                    orderItem.setBook(cartItem.getBook());//订单项包含的图书
                    orderItem.setCount(cartItem.getPurchaseNum());//购买数量
                    orders.getList().add(orderItem);//将订单项添加到订单中
                }
                OrderService orderService = new OrderServiceImpl();//多态获取对象
                int order_count = orderService.saveOrder(orders);//向数据库中插入数据
                if (order_count > 0) {
                    request.setAttribute("orderNo",orders.getOid());
                    request.getSession().removeAttribute("cart");//购物车清除
                    request.getRequestDispatcher("/shop/pages/cart/checkout.jsp").forward(request,response);
                }else {
                    request.setAttribute("msg", "添加购物车失败，请重新添加");
                    request.getRequestDispatcher("/shop/pages/cart/cart.jsp").forward(request,response);
                }
            }
        }
    }
}
