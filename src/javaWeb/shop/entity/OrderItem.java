package javaWeb.shop.entity;

import java.math.BigDecimal;

/**
 * 订单项实体类
 */
public class OrderItem {
    private String itemId;//订单项Id
    private Integer count;//购买数量
    private BigDecimal amount;//购买金额
    private Book book;//订单项包含的图书
    private Orders order;//订单项所属订单

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
