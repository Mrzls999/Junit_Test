package javaWeb.shop.entity;

import java.math.BigDecimal;

/**
 * 购物项
 */
public class CartItem {
    private Book book;//图书信息
    private Integer purchaseNum;//购买数量
    private BigDecimal purchaseAmount;//购买金额

    public CartItem() {
    }

    public CartItem(Book book, Integer purchaseNum, BigDecimal purchaseAmount) {
        this.book = book;
        this.purchaseNum = purchaseNum;
        this.purchaseAmount = purchaseAmount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }
}
