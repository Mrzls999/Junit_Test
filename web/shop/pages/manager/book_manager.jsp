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
<%--        <a href="${pageContext.request.contextPath}/book?meth=getAllBooks">图书管理</a>--%>
        <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=1&bookName="${requestScope.bookTile}">图书管理</a>
        <a href="order_manager.html">订单管理</a>
        <a href="../../index.jsp">返回商城</a>
    </div>
</div>

<div id="main" class="box_no">
    <div class="book_cond">
        图书名称：<input type="text" style="width: 100px" name="bookName" value="${requestScope.bookTile}">
        <button onclick="showPaginationFromCondition(1)">查询</button>
    </div>
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.bookPageBeanFromCondition.list}" var="book" >
            <tr>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="${pageContext.request.contextPath}/book?meth=displayDataById&Id=${book.id}" class="a_green">修改</a></td>
                <td><a href="javascript:void(0)" onclick="delOneBook(${book.id})">删除</a></td>
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
    <div id="page_nav">
        <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=1&bookName=${requestScope.bookTile}">首页</a>
        <c:if test="${requestScope.bookPageBeanFromCondition.pageNo==1}">
            <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=1&bookName=${requestScope.bookTile}">上一页</a>
        </c:if>
        <c:if test="${requestScope.bookPageBeanFromCondition.pageNo!=1}">
            <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${requestScope.bookPageBeanFromCondition.pageNo-1}&bookName=${requestScope.bookTile}">上一页</a>
        </c:if>
        <c:forEach begin="1" end="${requestScope.bookPageBeanFromCondition.totalPageNo}" varStatus="pNo">
            <c:if test="${requestScope.bookPageBeanFromCondition.pageNo==pNo.count}">
                <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${pNo.count}&bookName=${requestScope.bookTile}"><b>【${pNo.count}】</b></a>
            </c:if>
            <c:if test="${requestScope.bookPageBeanFromCondition.pageNo!=pNo.count}">
                <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${pNo.count}&bookName=${requestScope.bookTile}">${pNo.count}</a>
            </c:if>
        </c:forEach>
        <c:if test="${requestScope.bookPageBeanFromCondition.pageNo==requestScope.bookPageBeanFromCondition.totalPageNo}">
            <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${requestScope.bookPageBeanFromCondition.totalPageNo}&bookName=${requestScope.bookTile}">下一页</a>
        </c:if>
        <c:if test="${requestScope.bookPageBeanFromCondition.pageNo!=requestScope.bookPageBeanFromCondition.totalPageNo}">
            <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${requestScope.bookPageBeanFromCondition.pageNo+1}&bookName=${requestScope.bookTile}">下一页</a>
        </c:if>
        <a href="${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=${requestScope.bookPageBeanFromCondition.totalPageNo}&bookName=${requestScope.bookTile}">末页</a>
        共${requestScope.bookPageBeanFromCondition.totalPageNo}页，${requestScope.bookPageBeanFromCondition.totalRecord}条记录
        到第<input value="${requestScope.bookPageBeanFromCondition.pageNo}" name="pn" id="pn_input"/>页
        <input type="button" value="确定" onclick="showPaginationFromCondition(${requestScope.bookPageBeanFromCondition.totalPageNo})" />
    </div>
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
    <%--function redirectToPage(totalPageNo){--%>
    <%--    let value = document.getElementsByName("pn")[0].value;--%>
    <%--    if(value<1){--%>
    <%--        window.location.href = "${pageContext.request.contextPath}/book?meth=showPagination&pageNo=1";--%>
    <%--    }else if(value>totalPageNo){--%>
    <%--        window.location.href = "${pageContext.request.contextPath}/book?meth=showPagination&pageNo="+totalPageNo;--%>
    <%--    }else {--%>
    <%--        window.location.href = "${pageContext.request.contextPath}/book?meth=showPagination&pageNo="+value;--%>
    <%--    }--%>
    <%--}--%>
    function showPaginationFromCondition(totalPageNo) {
        let bookName = document.getElementsByName("bookName")[0].value;//得到书的模糊名字
        let value = document.getElementsByName("pn")[0].value;//得到你要跳转的页面数
        if(value<1){
            window.location.href = "${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo=1&bookName="+bookName;
        }else if(value>totalPageNo){
            window.location.href = "${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo="+totalPageNo+"&bookName="+bookName;
        }else {
            window.location.href = "${pageContext.request.contextPath}/book?meth=showPaginationFromCondition&pageNo="+value+"&bookName="+bookName;
        }
    }
</script>
</html>
