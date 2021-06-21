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
        <a href="book_manager.jsp">图书管理</a>
        <a href="order_manager.html">订单管理</a>
        <a href="../../index.html">返回商城</a>
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
                <td><input name="book_name" type="text" value=""/></td>
                <td><input name="book_price" type="text" value=""/></td>
                <td><input name="book_author" type="text" value=""/></td>
                <td><input name="book_sales" type="text" value=""/></td>
                <td><input name="book_stock" type="text" value=""/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
</div>
</body>
</html>