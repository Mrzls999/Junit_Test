<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/6/18
  Time: 下午5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加图书</title>
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
    <span class="wel_word">添加图书</span>
    <div>
        <a href="${pageContext.request.contextPath}/book?meth=getAllBooks">图书管理</a>
        <a href="${pageContext.request.contextPath}/shop/pages/manager/order_manager.html">订单管理</a>
        <a href="<%=request.getContextPath()%>/shop/index.jsp">返回商城</a>
    </div>
</div>

<div id="main">
    <form action="${pageContext.request.contextPath}/book?meth=addBook" method="post">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td>操作</td>
                <td>是否插入成功</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="" /></td>
                <td><input name="price" type="text" value=""/></td>
                <td><input name="author" type="text" value=""/></td>
                <td><input name="sales" type="text" value=""/></td>
                <td><input name="stock" type="text" value=""/></td>
                <td><input type="submit" value="提交"/></td>
                <c:if test="${requestScope.success_addBookFlag==false}">
                    <td style="color: red">失败</td>
                </c:if>
                <c:if test="${requestScope.success_addBookFlag==true}">
                    <td style="color: green">成功</td>
                </c:if>
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