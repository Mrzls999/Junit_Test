<%@ page import="javaWeb.entity.User" %>

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
</body>
</html>
