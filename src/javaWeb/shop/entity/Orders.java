package javaWeb.shop.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders {
    private String Oid;//订单Id   利用UUID生成
    private Date ordersTime;//下单时间  当前时间
    private BigDecimal totalPrice;//总金额 通过session域中的购物车信息获取
    private Integer state;//订单状态：1未付款，2已支付  刚开始的默认值1
    private User user;//订单所属的用户 session域

    private List<OrderItem> list = new ArrayList<>();//一个订单有多个订单项

    public String getOid() {
        return Oid;
    }

    public void setOid(String oid) {
        Oid = oid;
    }

    public Date getOrdersTime() {
        return ordersTime;
    }

    public void setOrdersTime(Date ordersTime) {
        this.ordersTime = ordersTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
