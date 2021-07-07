package javaWeb.shop.entity;

import javaWeb.shop.service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车类
 */
public class Cart {
    private Map<String, CartItem> map = new HashMap<>();//购物项<bookId,CartItem>
    private Integer totalProductsNums;//总商品数量
    private BigDecimal totalAmount;//总金额

    //1.获取购物车所有购物项
    public List<CartItem> getAllCartItems() {
        Collection<CartItem> values = map.values();
        return new ArrayList<>(values);
    }

    //2.添加图书到购物车
    public void addBookToCart(String bookId) {//应该是有一个是否添加成功的标识的
        CartItem cartItem = map.get(bookId);//获取这个图书
        if (cartItem == null) {//如果为空，那么说明购物车中没有这个图书信息，第一次添加
            String sql = "SELECT * FROM books WHERE id=" + bookId;
            Book book = new BookServiceImpl().displayDataById(sql);
            map.put(bookId, new CartItem(book, 1, book.getPrice()));
        } else {//如果不空，那么说明购物车中有这个图书信息，在这个的基础上添加
            cartItem.setPurchaseNum(cartItem.getPurchaseNum() + 1);
            cartItem.setPurchaseAmount(cartItem.getPurchaseAmount().add(cartItem.getBook().getPrice()));
            map.put(bookId, cartItem);
        }
    }

    //3.删除购物项
    public void delCartItem(String bookId) {
        map.remove(bookId);
    }
    //4.清空购物车
    public void clearCart(){
        map.clear();
    }

    //5.更改购物车图书数量
    public void updateBookNums(String bookId,int nums){
        CartItem cartItem = map.get(bookId);
        cartItem.setPurchaseNum(nums);
    }

    public Cart() {
    }

    public Cart(Map<String, CartItem> map, Integer totalProductsNums, BigDecimal totalAmount) {
        this.map = map;
        this.totalProductsNums = totalProductsNums;
        this.totalAmount = totalAmount;
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public Integer getTotalProductsNums() {
        return totalProductsNums;
    }

    public void setTotalProductsNums(Integer totalProductsNums) {
        this.totalProductsNums = totalProductsNums;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
