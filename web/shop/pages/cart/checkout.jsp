<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/8/6
  Time: 14:58:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
<%--    <img class="logo_img" alt="" src="../../static/img/logo.gif" >--%>
    <span class="wel_word">结算</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
        <a href="../order/order.html">我的订单</a>
        <a href="${pageContext.request.contextPath}/user?meth=logout">注销</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/cart?meth=getAllCartItems">返回</a>
    </div>
</div>

<div id="main">

    <h1>你的订单已结算，订单号为${requestScope.orderNo}</h1>


</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2021
		</span>
</div>
</body>
</html>
