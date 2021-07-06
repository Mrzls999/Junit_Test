<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/7/6
  Time: 9:33:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  response.sendRedirect(request.getContextPath()+"/book?meth=showPagination&pageNo=1");
%>