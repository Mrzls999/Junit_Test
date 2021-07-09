package javaWeb.shop.web.pro;

/**
 * 购物车类
 */

import javaWeb.shop.entity.Book;
import javaWeb.shop.entity.Cart;
import javaWeb.shop.entity.CartItem;
import javaWeb.shop.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends BaseServlet {

    /**
     * 获取购物车所有购物项
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void getAllCartItems(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        List<CartItem> allCartItems = cart.getAllCartItems();
        request.getSession().setAttribute("cartItems", allCartItems);
        response.sendRedirect(request.getContextPath() + "/shop/pages/cart/cart.jsp");
    }

    /**
     * 添加图书到购物车功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bookId = request.getParameter("bookId");
        HttpSession session = request.getSession();
        Cart sessionCart = (Cart) session.getAttribute("cart");//获取购物车session
        if (sessionCart != null) {//如果已经有session，则
            Map<String, CartItem> map = sessionCart.getMap();
            CartItem cartItem = map.get(bookId);
            if (cartItem == null) {//如果没有这个购物项，则重新添加一个
                sessionCart.addBookToCart(bookId);
                sessionCart.setTotalProductsNums(sessionCart.getTotalProductsNums() + 1);
                sessionCart.setTotalAmount(sessionCart.getTotalAmount().add(new BookServiceImpl().displayDataById("SELECT * FROM books WHERE id=" + bookId).getPrice()));
            } else {
                cartItem.setPurchaseNum(cartItem.getPurchaseNum() + 1);
                cartItem.setPurchaseAmount(cartItem.getPurchaseAmount().add(cartItem.getBook().getPrice()));
                sessionCart.setTotalProductsNums(sessionCart.getTotalProductsNums() + 1);
                sessionCart.setTotalAmount(sessionCart.getTotalAmount().add(cartItem.getBook().getPrice()));
            }
            session.setAttribute("cart", sessionCart);
        } else {//如果没有这个session，则
            Cart cart = new Cart();
            cart.addBookToCart(bookId);
            cart.setTotalProductsNums(1);
            cart.setTotalAmount(new BookServiceImpl().displayDataById("SELECT * FROM books WHERE id=" + bookId).getPrice());
            session.setAttribute("cart", cart);
        }
        getAllCartItems(request, response);
    }

    /**
     * 删除购物项
     * @param request
     * @param response
     */
    protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {//如果购物车有东西
            String bookId = request.getParameter("bookId");
            cart.setTotalProductsNums(cart.getTotalProductsNums()-cart.getMap().get(bookId).getPurchaseNum());
            cart.setTotalAmount(cart.getTotalAmount().subtract(cart.getMap().get(bookId).getPurchaseAmount()));
            cart.delCartItem(bookId);
            session.setAttribute("cart",cart);
            getAllCartItems(request, response);
        }
        //如果购物车没有东西，那就算了。
    }

}
