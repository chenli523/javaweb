<%--
  Created by IntelliJ IDEA.
  User: a123
  Date: 3/27/21
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
</head>
<body>
<div class="header">
    <div class="w">
        <div class="header-left">
            <a href="index.jsp">
                <img src="static/img/logo.gif" alt=""
                /></a>
        </div>
        <%@ include file="/WEB-INF/include/header.jsp"%>
    </div>
</div>
    <h2>Error 500, the BookStore Crashed</h2>
    <div class="list">
        <div class="w">
            <%@ include file="/WEB-INF/include/footerTop.jsp"%>
            <%@ include file="/WEB-INF/include/footer.jsp"%>
        </div>
    </div>
</body>
</html>
