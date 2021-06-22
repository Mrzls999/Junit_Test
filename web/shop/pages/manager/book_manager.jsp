<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/6/18
  Time: 下午5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
</head>
<body>

<div id="header">
<%--    <img class="logo_img" alt="" src="${pageContext.request.contextPath}/shop/static/img/logo.gif" >--%>
    <span class="wel_word">图书管理系统</span>
    <div>
        <a href="${pageContext.request.contextPath}/book?meth=getAllBooks">图书管理</a>
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
        <c:forEach items="${requestScope.allBooks}" var="book" >
            <tr>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="${pageContext.request.contextPath}/book?meth=displayDataById&Id=${book.id}" class="a_green">修改</a></td>
                <td><a onclick="delOneBook(${book.id})">删除</a></td>
            </tr>
        </c:forEach>
        <%--看是否删除成功--%>
        <c:if test="${requestScope.delBookSuccess_Flag==true}">
            <script type='text/javascript'>alert('删除成功');</script>
        </c:if>
        <c:if test="${requestScope.delBookSuccess_Flag==false}">
           <script type='text/javascript'>alert('删除失败');</script>
        </c:if>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="<%=request.getContextPath()%>/shop/pages/manager/book_add.jsp">添加图书</a></td>
        </tr>
    </table>
</div>

<div id="bottom">
		<span>
			书城.Copyright &copy;2021
		</span>
</div>
</body>
<script>
    function delOneBook(bookID){
        const delFlag = window.confirm('是否删除这本书籍');//点击确定返回true，点击取消返回false
        console.log(delFlag);
        if(delFlag){
            window.location.href = "http://127.0.0.1:8080/${pageContext.request.contextPath}/book?meth=delBookFromID&id="+bookID;
        }
    }
</script>
</html>
