<%--
  Created by IntelliJ IDEA.
  User: Fog
  Date: 2017/12/18
  Time: 下午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="/assets/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/login.css" rel="stylesheet">
    <title>火车订票系统</title>
  </head>
  <body class="index-bg" onload="signAction()">
  <%
    if (request.getParameter("loginSuccess") == "1") {
  %>
  <div class="alert alert-success signaction" role="alert">登录成功！</div>
  <%
    }
  %>
  <%
    if (request.getParameter("registerSuccess") == "1") {
  %>
  <div class="alert alert-success signaction" role="alert">注册成功！</div>
  <%
    }
  %>
  <div class="index-container">
    <nav class="navbar navbar-default ">
      <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">火车订票</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">首页 <span class="sr-only">(current)</span></a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
        <%
        boolean isAuthentication = false;
        if (!isAuthentication) {
        %>
            <li><a href="/login.jsp">登录</a></li>
            <li><a href="/register.jsp">注册</a></li>
        <%
        } else {
        %>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">修改昵称</a></li>
            <li><a href="#">修改密码</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">修改所在地</a></li>
          </ul>
        </li>
        <%
        }
        %>
          </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <form action="/action/search.action" accept-charset="UTF-8" method="post">
      <div class="index-main">
        <a id="switch"><img src="/assets/images/icons8-switch-100.png" class="index-icon1"></a>
        <div class="index-block">
          <div class="jumbotron">
            <h1 id="from-result">出发</h1>
            <div class="row">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                  </span>
                  <input type="text" class="form-control" name="from" id="from-place" placeholder="Search for...">
                </div><!-- /input-group -->
              </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
          </div>
        </div>
        <img src="/assets/images/icons8-train-100.png" class="index-icon2">
        <div class="index-block">
          <div class="jumbotron">
            <h1 id="destination-result">目的</h1>
            <div class="row">
              <div class="col-lg-6">
                <div class="input-group">
                  <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                  </span>
                  <input type="text" class="form-control" name="des" id="destination-place" placeholder="Search for...">
                </div><!-- /input-group -->
              </div><!-- /.col-lg-6 -->
            </div><!-- /.row -->
          </div>
        </div>
        <div class="index-block">
          <div class="jumbotron">
            <h1>时间</h1>
            <input type="date" class="select-date" name="date" value="2017-12-31"/>
          </div>
        </div>
      </div>
      <input type="submit" name="commit" value="搜索" class="search-button" />
      <button type="button" class="search-button" id="advanced-search">高级搜索</button>
      <input type="submit" name="time" value="最短时间" class="search-button advanced ad-search"/>
      <input type="submit" name="money" value="最少金额" class="search-button advanced ad-search"/>
      <div class="row advanced">
        <div class="col-lg-6">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="中转站">
            <span class="input-group-btn">
              <input type="submit" name="transfer" value="搜索" class="btn btn-default"/>
            </span>
          </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
      </div><!-- /.row -->
    </form>
  </div>

  <script src="/assets/bootstrap/jquery.min.js"></script>
  <script src="/assets/bootstrap/bootstrap.min.js"></script>
  <script src="/assets/js/js.js"></script>
  </body>
</html>
