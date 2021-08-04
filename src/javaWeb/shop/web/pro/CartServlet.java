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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.L;

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
        if (cart != null) {
            List<CartItem> allCartItems = cart.getAllCartItems();
            request.getSession().setAttribute("cartItems", allCartItems);
        } else {
            request.getSession().removeAttribute("cartItems");
        }
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
                sessionCart.setTotalAmount(sessionCart.getTotalAmount().add(new BookServiceImpl().displayDataById("SELECT * FROM t_books WHERE id=" + bookId).getPrice()));
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
            cart.setTotalAmount(new BookServiceImpl().displayDataById("SELECT * FROM t_books WHERE id=" + bookId).getPrice());
            session.setAttribute("cart", cart);
        }
        getAllCartItems(request, response);
    }

    /**
     * 删除购物项
     *
     * @param request
     * @param response
     */
    protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {//如果购物车有东西
            String bookId = request.getParameter("bookId");
            cart.setTotalProductsNums(cart.getTotalProductsNums() - cart.getMap().get(bookId).getPurchaseNum());
            cart.setTotalAmount(cart.getTotalAmount().subtract(cart.getMap().get(bookId).getPurchaseAmount()));
            cart.delCartItem(bookId);
            session.setAttribute("cart", cart);
            getAllCartItems(request, response);
        }
        //如果购物车没有东西，那就算了。
    }

    /**
     * 清除购物车
     *
     * @param request
     * @param response
     */
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("cart");
        getAllCartItems(request, response);
    }

    /**
     * 更改购物车图书数量
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void updateBookNums(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        String bookId = request.getParameter("bookId");//得到商品id
        int nums = Integer.parseInt(request.getParameter("nums"));//得到要修改的这个图书的数量
        if (nums < 1) {//如果小于1个，直接删除这个购物项
            delCartItem(request, response);
        }else{//否则
            cart.setTotalProductsNums(cart.getTotalProductsNums() + (nums - cart.getMap().get(bookId).getPurchaseNum()));
            cart.setTotalAmount(cart.getTotalAmount().add(BigDecimal.valueOf((long) (nums - cart.getMap().get(bookId).getPurchaseNum())).multiply(cart.getMap().get(bookId).getBook().getPrice())));
            cart.updateBookNums(bookId, nums);
            session.setAttribute("cart", cart);
            getAllCartItems(request, response);
        }
    }
}
