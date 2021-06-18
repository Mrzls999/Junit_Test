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
    <title>图书管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="${pageContext.request.contextPath}/shop/static/img/logo.gif" >
    <span class="wel_word">图书管理系统</span>
    <div>
        <a href="book_manager.jsp">图书管理</a>
        <a href="order_manager.html">订单管理</a>
        <a href="../../index.jsp">返回商城</a>
    </div>
</div>

<div id="main" class="box_no">
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
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="book_edit.jsp" class="a_green">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="book_edit.jsp" class="a_green">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="book_edit.jsp" class="a_green">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>

        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="book_edit.jsp" class="a_green">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>
        <tr>
            <td>时间简史</td>
            <td>20.00</td>
            <td>霍金</td>
            <td>200</td>
            <td>400</td>
            <td><a href="book_edit.jsp" class="a_green">修改</a></td>
            <td><a href="#">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
</div>

<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
</div>
</body>
</html>
