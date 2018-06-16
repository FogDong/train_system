<%--
  Created by IntelliJ IDEA.
  User: Fog
  Date: 2017/12/31
  Time: 上午12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/assets/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/login.css" rel="stylesheet">
    <title>车票</title>
</head>
<body class="search-bg">
<div class="search-container">
    <nav class="navbar navbar-default" id="search-nav">
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

    <div class="search-bottom">
        <div class="search-bar">
            <input type="text" class="form-control search-input" id="search-from" placeholder="出发地">
            <a id="search-switch"><img src="/assets/images/icons8-switch-100.png" class="search-icon"></a>
            <input type="text" class="form-control search-input" id="search-des" placeholder="目的地">
            <img src="/assets/images/icons8-train-100.png" class="search-icon">
            <input type="date" class="search-time" value="2017-12-31"/>
            <img src="/assets/images/icons8-search-100.png" class="search-icon">
        </div>
        <div class="route">
            <h2 class="route-place">
                <strong><%=request.getParameter("from-place")%></strong>
                <img src="/assets/images/icons8-forward-100.png" class="img-arrow">
                <strong><%=request.getParameter("des-place")%></strong>
            </h2>
            <b class="route-info">
                <span><%=request.getParameter("date")%></span>
                <span>共<%=request.getParameter("count")%>个车次</span>
            </b>
        </div>
        <div class="train-box">
            <div class="train-title">
                <dl class="list-header">
                    <dd>车次信息</dd>
                    <dd class="train-active">发/到时间<i class="glyphicon glyphicon-arrow-up train-active"></i></dd>
                    <dd>发/到站</dd>
                    <dd>运行时长<i class="glyphicon glyphicon-arrow-up"></i></dd>
                    <dd>参考价<i class="glyphicon glyphicon-arrow-up"></i></dd>
                </dl>
            </div>
            <%
                if (request.getParameter("isTransfer") == "0") {
            %>
            <c:forEach items = "${list}" var = "list">
            <div class="train-list">
                <div class="list-body">
                    <div class="w1">
                        <div class="r1 l1"><b>${list.trainNumber}</b></div>
                    </div>
                    <div class="w2">
                        <div class="r2"><b>${list.departTime} </b></div>
                        <div class="r2">${list.arrivalTime} </div>
                    </div>
                    <div class="w3">
                        <div class="r3">
                            <div class="begin">
                                <c:when test="${list.from == list.from-place}">
                                    <div class="from">始</div>
                                </c:when>
                                <c:otherwise>
                                    <div class="pass">过</div>
                                </c:otherwise>
                                <div class="r3-place">${list.from}</div>
                            </div>
                            <div class="end">
                                <c:when test="${list.des == list.des-place}">
                                    <div class="des">终</div>
                                </c:when>
                                <c:otherwise>
                                    <div class="pass">过</div>
                                </c:otherwise>
                                <div class="r3-place">${list.des}</div>
                            </div>
                        </div>
                    </div>
                    <div class="w4">
                        <div class="r4">${list.time}</div>
                    </div>
                    <div class="w5">
                        <div class="">
                            <div class="second">
                                <div class="seat">二等座</div>
                                <div class="price"><b>¥ ${list.secondPrice} </b></div>
                                <div class="number">余${list.secondTickets}张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="first">
                                <div class="seat">一等座</div>
                                <div class="price"><b>¥ ${list.firstPrice} </b></div>
                                <div class="number">余${list.firstTickets}张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="business">
                                <div class="seat">商务座</div>
                                <div class="price"><b>¥ ${list.businessPrice} </b></div>
                                <div class="number">余${list.businessTickets}张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <hr class="hr-split" />
                </div>
                </c:forEach>
        <%
            } else {
        %>
                <c:forEach items = "${list}" var = "list">
                <div class="train-list">
                    <div class="list-body">
                        <div class="w1">
                            <div class="r1 l1"><b>${list.trainNumber}</b></div>
                        </div>
                        <div class="w2">
                            <div class="r2"><b>${list.departTime} </b></div>
                            <div class="r2">${list.arrivalTime} </div>
                        </div>
                        <div class="w3">
                            <div class="r3">
                                <div class="begin">
                                    <c:when test="${list.from == list.from-place}">
                                        <div class="from">始</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="pass">过</div>
                                    </c:otherwise>
                                    <div class="r3-place">${list.from}</div>
                                </div>
                                <div class="end">
                                    <c:when test="${list.des == list.des-place}">
                                        <div class="des">终</div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="pass">过</div>
                                    </c:otherwise>
                                    <div class="r3-place">${list.des}</div>
                                </div>
                            </div>
                        </div>
                        <div class="w4">
                            <div class="r4">${list.time}</div>
                        </div>
                        <div class="w5">
                            <div class="">
                                <div class="second">
                                    <div class="seat">二等座</div>
                                    <div class="price"><b>¥ ${list.secondPrice} </b></div>
                                    <div class="number">余${list.secondTickets}张</div>
                                    <div class="buy"><button class="buy-btn">预定</button></div>
                                </div>
                                <div class="first">
                                    <div class="seat">一等座</div>
                                    <div class="price"><b>¥ ${list.firstPrice} </b></div>
                                    <div class="number">余${list.firstTickets}张</div>
                                    <div class="buy"><button class="buy-btn">预定</button></div>
                                </div>
                                <div class="business">
                                    <div class="seat">商务座</div>
                                    <div class="price"><b>¥ ${list.businessPrice} </b></div>
                                    <div class="number">余${list.businessTickets}张</div>
                                    <div class="buy"><button class="buy-btn">预定</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:when test="${list.index % 2 == 0}">
                        <div class="split">
                            <hr class="hr-split" />
                            <div class="transfer">${list.des}换乘</div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <hr class="hr-split" />
                        </div>
                    </c:otherwise>
                    </c:forEach>
        <%
            }
        %>
        <div class="route">
            <h2 class="route-place">
                <strong>上海</strong>
                <img src="/assets/images/icons8-forward-100.png" class="img-arrow">
                <strong>长沙</strong>
            </h2>
            <b class="route-info">
                <span>2017/12/31</span>
                <span>共29个车次</span>
            </b>
        </div>
        <div class="train-box">
            <div class="train-title">
                <dl class="list-header">
                    <dd>车次信息</dd>
                    <dd class="train-active">发/到时间<i class="glyphicon glyphicon-arrow-up train-active"></i></dd>
                    <dd>发/到站</dd>
                    <dd>运行时长<i class="glyphicon glyphicon-arrow-up"></i></dd>
                    <dd>参考价<i class="glyphicon glyphicon-arrow-up"></i></dd>
                </dl>
            </div>
            <div class="train-list">
                <div class="list-body">
                    <div class="w1">
                        <div class="r1 l1"><b>G1321</b></div>
                    </div>
                    <div class="w2">
                        <div class="r2"><b>06:11</b></div>
                        <div class="r2">11:57 </div>
                    </div>
                    <div class="w3">
                        <div class="r3">
                            <div class="begin">
                                <div class="from">始</div>
                                <div class="r3-place">上海</div>
                            </div>
                            <div class="end">
                                <div class="pass">过</div>
                                <div class="r3-place">长沙</div>
                            </div>
                        </div>
                    </div>
                    <div class="w4">
                        <div class="r4">5小时46分</div>
                    </div>
                    <div class="w5">
                        <div class="">
                            <div class="second">
                                <div class="seat">二等座</div>
                                <div class="price"><b>¥ 478.0</b></div>
                                <div class="number">余99张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="first">
                                <div class="seat">一等座</div>
                                <div class="price"><b>¥ 798.5</b></div>
                                <div class="number">余16张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="business">
                                <div class="seat">商务座</div>
                                <div class="price"><b>¥ 1497.5 </b></div>
                                <div class="number">余6张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="split">
                    <hr class="hr-split" />
                    <div class="transfer">杭州换乘</div>
                </div>
                <div class="list-body">
                    <div class="w1">
                        <div class="r1 l1"><b>G1321</b></div>
                    </div>
                    <div class="w2">
                        <div class="r2"><b>06:11</b></div>
                        <div class="r2">11:57 </div>
                    </div>
                    <div class="w3">
                        <div class="r3">
                            <div class="begin">
                                <div class="from">始</div>
                                <div class="r3-place">上海</div>
                            </div>
                            <div class="end">
                                <div class="pass">过</div>
                                <div class="r3-place">长沙</div>
                            </div>
                        </div>
                    </div>
                    <div class="w4">
                        <div class="r4">5小时46分</div>
                    </div>
                    <div class="w5">
                        <div class="">
                            <div class="second">
                                <div class="seat">二等座</div>
                                <div class="price"><b>¥ 478.0</b></div>
                                <div class="number">余99张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="first">
                                <div class="seat">一等座</div>
                                <div class="price"><b>¥ 798.5</b></div>
                                <div class="number">余16张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                            <div class="business">
                                <div class="seat">商务座</div>
                                <div class="price"><b>¥ 1497.5 </b></div>
                                <div class="number">余6张</div>
                                <div class="buy"><button class="buy-btn">预定</button></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div><hr class="hr-split" /></div>
            </div>
        </div>
    </div>
</div>
<script src="/assets/bootstrap/jquery.min.js"></script>
<script src="/assets/bootstrap/bootstrap.min.js"></script>
</body>
</html>
