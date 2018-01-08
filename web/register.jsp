<%--
  Created by IntelliJ IDEA.
  User: Fog
  Date: 2017/12/28
  Time: 下午9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/assets/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/login.css" rel="stylesheet">
    <title>注册</title>
</head>
<body lang="zh-CN" class="sign-bg" onload="signAction()">
<%
    if (request.getParameter("registerSuccess") == "0") {
%>
<div class="alert alert-danger signaction" role="alert">注册失败，请重新注册！</div>
<%
    }
%>
<div class="alert alert-danger info" role="alert"></div>
<div class="sign">
    <div class="logo"><a href="/index.jsp"><img src="/assets/images/icons8-train-50.png" alt="Logo" /></a></div>
    <div class="main">
        <h4 class="title">
            <a class="normal-title" href="/login.jsp">登录</a>
            <b>·</b>
            <a class="normal-title active" href="#">注册</a>
        </h4>
        <div>
            <form action="/action/register.action" accept-charset="UTF-8" method="post">
                <div class="input-prepend">
                    <input placeholder="请输入账号" type="text" name="username" class="user-input one" onblur="isUsername()"/>
                    <span class="icon glyphicon glyphicon-user"></span>
                </div>
                <div class="input-prepend">
                    <input placeholder="请输入密码" type="password" name="password" class="user-input two-register" onblur="isPassword()"/>
                    <span class="icon glyphicon glyphicon-eye-close"></span>
                </div>
                <div class="input-prepend">
                    <input placeholder="请重复一遍密码" type="password" name="repeatpassword" class="user-input three" onblur="isSame()"/>
                    <span class="icon glyphicon glyphicon-eye-close"></span>
                    <input type="submit" name="commit" value="登录" class="sign-in-button register-btn" data-disable-with="注册" />
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/assets/bootstrap/jquery.min.js"></script>
<script src="/assets/bootstrap/bootstrap.min.js"></script>
<script src="/assets/js/js.js"></script>
</body>
</html>

