<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/8/30
  Time: 10:14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/shop/static/script/jquery-1.7.2.js"></script>
<head>
    <title>生成表格</title>
</head>
<body>
<input type="button" id="generateTable" value="生成表格"/>
<div id="dId">

</div>
</body>
<script>
    $(function (){
        $("#generateTable").click(function (){
            $("#dId").html("<table id='tableId' style='text-align:center/*水平居中*/;vertical-align: center/*垂直居中*/;width:200px;border:1px green solid;'><tr><td>name</td><td>age</td></tr></table>")
            $.ajax({
                url:"${pageContext.request.contextPath}/generateTableServlet",
                type:"post",
                data:"json",
                success:function (datas){
                    for(let i=0; i<datas.length; i++){
                        $("#tableId").append("<tr><td>"+datas[i].name+"</td><td>"+datas[i].age+"</td></tr>");
                    }
                },
                error:function(){
                    alert("error");
                },
                dataType:"json"
            })
        })
    })
</script>
</html>
