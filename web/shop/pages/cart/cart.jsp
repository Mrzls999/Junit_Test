<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/7/8
  Time: 17:04:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>购物车</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
</head>
<body>

<div id="header">
<%--  <img class="logo_img" alt="" src="/shop/static/img/logo.gif" >--%>
  <span class="wel_word">购物车</span>
  <div>
    <span>欢迎<span class="um_span">${cookie.userName.value}</span>光临会员书城</span>
    <a href="../order/order.html">我的订单</a>
    <a href="${pageContext.request.contextPath}/user?meth=logout">注销</a>&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/shop/index.jsp">返回</a>
  </div>
</div>

<div id="main" class="box_order">
  <table>
    <tr>
      <td>商品名称</td>
      <td>数量</td>
      <td>单价</td>
      <td>金额</td>
      <td>操作</td>
    </tr>
    <c:forEach items="${sessionScope.cartItems}" var="cartItem">
      <tr>
        <td>${cartItem.book.title}</td>
        <td>
          <input id="cartItemNums" onblur="updateBookNums(${cartItem.book.id})" type="text" size="10" value="${cartItem.purchaseNum}" />
        </td>
        <td>${cartItem.book.price}</td>
        <td>${cartItem.purchaseAmount}</td>
        <td><a href="${pageContext.request.contextPath}/cart?meth=delCartItem&bookId=${cartItem.book.id}">删除</a></td>
      </tr>
    </c:forEach>
  </table>
  <div class="cart_info">
    <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalProductsNums}</span>件商品</span>
    <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalAmount}</span>元</span>
    <span class="cart_span"><a href="${pageContext.request.contextPath}/cart?meth=clearCart">清空购物车</a></span>
    <span class="cart_span"><a href="#">继续购物</a></span>
    <span class="cart_span"><a href="${pageContext.request.contextPath}/shop/pages/cart/checkout.html">去结账</a></span>
  </div>

</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2021
		</span>
</div>
</body>
<script>
  function updateBookNums(bookId) {
    let cartItemNums = document.getElementById("cartItemNums").value;
    location.href = "${pageContext.request.contextPath}/cart?meth=updateBookNums&bookId="+bookId+"&nums="+cartItemNums;
  }
</script>
</html>
