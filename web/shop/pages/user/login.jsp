<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/6/17
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="utf-8">
<head>
    <meta charset="UTF-8">
    <title>会员登录页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/shop/static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            //登录中的用户名、密码进行非空验证
            //关联submit按钮的单击事件
            $("#sub_btn").click(function () {
                //用户名非空验证
                const username = $("#username").val();
                if (username === "" || username == null) {
                    alert("用户名不能为空，请重新输入！");
                    //取消submit按钮的默认行为，不提交表单
                    return false;
                }
                //密码非空验证
                var pwd = $("#password").val();
                if (pwd == null || pwd === "") {
                    alert("密码不能为空，请重新输入！");
                    return false;
                }
            });
        });
    </script>

</head>
<body>
<div id="login_header">
<%--    <img class="logo_img" alt="" src="${pageContext.request.contextPath}/shop/static/img/logo.gif">--%>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>会员登录</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">请输入用户名和密码</span>
                    <span style="color:red;">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/user?meth=login" method="post"><!---将shopLogin改为user-->
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                    <div class="tit">
                        <a href="${pageContext.request.contextPath}/shop/pages/user/regist.jsp">立即注册</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				书城.Copyright &copy;2021
			</span>
</div>
</body>
</html>