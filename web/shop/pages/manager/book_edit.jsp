<%@ page import="org.apache.commons.beanutils.BeanUtils" %>
<%@ page import="javaWeb.shop.entity.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/6/18
  Time: 下午5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
<%--    <img class="logo_img" alt="" src="${pageContext.request.contextPath}/shop/static/img/logo.gif" >--%>
    <span class="wel_word">编辑图书</span>
    <div>
        <a href="${pageContext.request.contextPath}/book?meth=getAllBooks">图书管理</a>
        <a href="order_manager.html">订单管理</a>
        <a href="${pageContext.request.contextPath}/shop/index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <form action="book_manager.html">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="${requestScope.bookById.title}"/></td>
                <td><input name="price" type="text" value="${requestScope.bookById.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.bookById.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.bookById.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.bookById.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<div id="bottom">
			<span>
				书城.Copyright &copy;2021
			</span>
</div>
</body>
</html>