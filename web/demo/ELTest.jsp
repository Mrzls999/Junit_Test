<%@ page import="javaWeb.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/6/17
  Time: 上午10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user = new User();
        user.setUsername("zz");
        user.setPassword("1234");
        request.setAttribute("user",user);
    %>
    ${user.username}
    ${user.password}
    ${pageContext.request.contextPath}

    <%
        request.setAttribute("user","zs");
        if(request.getAttribute("user")=="zs"){
            response.getWriter().write("user==zs");
        }else {
            response.getWriter().write("user!=zs");
        }
    %>

    <c:if test="${user=='zs'}">
        <span style="color: red">${user}</span>
    </c:if>
</body>
</html>
