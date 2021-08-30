<%--
  Created by IntelliJ IDEA.
  User: zls
  Date: 2021/7/5
  Time: 16:31:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员注册页面</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/shop/static/css/style.css" >
    <style type="text/css">
        .login_form{
            height:445px;
            margin-top: 18px;
        }
    </style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/shop/static/script/jquery-1.7.2.js"></script>
</head>
<body>
<div id="login_header">
    <!--			<img class="logo_img" alt="" src="../../static/img/logo.gif" >-->
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册商城会员</h1>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/user?meth=register" method="post"><!---将shopRegister改为user-->
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
                        <br />
                        <br />
                        <label>验证码：</label>
                        <input class="itxt inp" type="text" style="width: 155px;" id="code" name="code"/>
<%--                        <img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 22px">--%>
                        <img id="sessionCode" alt="" onclick="verifyCode()" src="${pageContext.request.contextPath}/Kaptcha.jpg" style="float: right; margin-right: 22px;width: 93px;height: 40px">
                        <br />
                        <span class="errorMsg" style="color:red">${requestScope.registerMsg}</span>
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />

                    </form>
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
<script>
    function verifyCode() {
        document.getElementById("sessionCode").src="${pageContext.request.contextPath}/Kaptcha.jpg?random=x";
    }
    $(function (){
        /*
 a)用户名、密码：只能是字母（大小写）、数字、_。6-18位。
 b)邮箱：API中的标准验证。
 * */
        //关联submit按钮单击事件
        let can_Register = false;
        $("#sub_btn").click(function () {
            //如果用户名重复，直接返回false
            if(!can_Register){
                return false;
            }
            //定义正则规则
            let utilReg = /^\w{6,18}$/;
            //验证用户名
            //获取用户名数据
            let username = $("#username").val();
            if(!utilReg.test(username)){
                alert("用户名输入有误，请重新输入。【用户名只能是字母（大小写）、数字、_。6-18位】");
                return false;
            }
            //验证密码
            let pwdValue = $("#password").val();
            if(!utilReg.test(pwdValue)){
                alert("密码输入有误，请重新输入。【密码只能是字母（大小写）、数字、_。6-18位】");
                return false;
            }
            //验证【确认密码】
            let rePwdValue = $("#repwd").val();
            if(pwdValue !== rePwdValue){
                alert("两次密码输入不一致，请重新输入！");
                return false;
            }
            //验证【邮箱】   b)邮箱：API中的标准验证。	zhang.san@16-3.com.cn   512111559@qq.com
            let emailValue = $("#email").val();
            let emailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
            if(!emailReg.test(emailValue)){
                alert("邮箱格式有误，请重新输入！");
                return false;
            }
            //验证【验证码】，非空
            let codeValue = $("#code").val();
            if(codeValue === "" || codeValue == null){
                alert("验证码不能为空，请重新输入！");
                return false;
            }

        });
        $("#username").blur(function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/user?meth=checkUserName",
                type:"post",
                data:{
                    username:$("#username").val()
                },
                dataType:"json",
                success:function(datas){
                    if(datas.code===10000) {
                        can_Register=true;
                        $("#registerName").remove();
                        $("#username").after("<span id='registerName' style='color:green;font-size:10px'><br>该用户名可以注册</span>");
                    }else{
                        $("#registerName").remove();
                        $("#username").after("<span id='registerName' style='color:red;font-size:10px'><br>该用户名已被注册</span>");
                    }
                },
                error:function(){
                    console.log("error");
                }
            })
        })
    })
</script>
</html>
