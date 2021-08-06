<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>书城首页</title>
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
</head>
<body>

<div id="header">
  <%--  <img class="logo_img" alt="" src="${pageContext.request.contextPath}/shop/static/img/logo.gif" >--%>
  <span class="wel_word">网上书城</span>
  <div class="user">
    <c:if test="${empty cookie.userName}">
      <a href="${pageContext.request.contextPath}/shop/pages/user/login.jsp">登录</a> |
      <a href="${pageContext.request.contextPath}/shop/pages/user/regist.html">注册</a> &nbsp;&nbsp;
    </c:if>
    <c:if test="${not empty cookie.userName}">
<%--    <span>欢迎<span class="um_span">${cookie.userName.value}--%>
    <span>欢迎<span class="um_span">${sessionScope.user.username}
    </c:if>
    <a href="${pageContext.request.contextPath}/cart?meth=getAllCartItems">购物车</a>
    <a href="${pageContext.request.contextPath}/shop/pages/manager/manager.jsp">后台管理</a>
  </div>
</div>

<div id="main">
  <div id="book">
    <div class="book_cond">
      价格：<input type="text" name="min">
      <span class="sp1">元</span> -
      <input type="text" name="max">
      <span class="sp1">元</span>
      <button>查询</button>
    </div>
    <div class="cont">
      <span>您的购物车中有3件商品</span>
      <!-- <div> -->
      您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
      <!-- </div> -->
    </div>
    <c:forEach items="${requestScope.bookPageBean.list}" var="book">
      <div class="b_list">
        <div class="img_div">
          <img class="book_img" alt="" src="${book.imgPath}" />
        </div>
        <div class="book_info">
          <div class="book_name">
            <span class="sp1">书名:</span>
            <span class="sp2">${book.title}</span>
          </div>
          <div class="book_author">
            <span class="sp1">作者:</span>
            <span class="sp2">${book.author}</span>
          </div>
          <div class="book_price">
            <span class="sp1">价格:</span>
            <span class="sp2">${book.price}</span>
          </div>
          <div class="book_sales">
            <span class="sp1">销量:</span>
            <span class="sp2">${book.sales}</span>
          </div>
          <div class="book_amount">
            <span class="sp1">库存:</span>
            <span class="sp2">${book.stock}</span>
          </div>
          <div class="book_add">
            <button onclick="addBookToCart(${book.id})">加入购物车</button>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>

  <div id="page_nav">
    <a href="#">首页</a>
    <a href="#">上一页</a>
    <a href="#">3</a>
    【4】
    <a href="#">5</a>
    <a href="#">下一页</a>
    <a href="#">末页</a>
    共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
    <input type="button" value="确定">
  </div>
</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2021
		</span>
</div>
</body>
<script>
  function addBookToCart(bookId) {
    window.location.href="${pageContext.request.contextPath}/cart?meth=addBookToCart&bookId="+bookId;
  }
</script>
</html>