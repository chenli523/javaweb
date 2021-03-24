<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="MyFirstServlet">Hello Servlet</a>
<form action="MyFirstServlet">
    <input type="submit">
</form>

<h2>GET request</h2>
<a href="FinalServlet?uname=zs">EndServlet</a>
<form action="FinalServlet" method="get">
    username：<input id="username" type="text" name="username" placeholder="please enter valid username" value="" /><br>
    password：<input id="pwd" type="password" name="password" value="123"/><br>
    <input id="btnSub" type="submit" value="登录" >
</form>
<h2>POST request</h2>
<form action="FinalServlet" method="post">
    username：<input id="username2" type="text" name="username" placeholder="please enter valid username" value="" /><br>
    password：<input id="pwd2" type="password" name="password" value="123"/><br>
    <input id="btnSub2" type="submit" value="登录" >
</form>

<h2>伪登录注册</h2>
<a href="pages/login.html" target="_blank">我要登录</a>
<br>
<a href="pages/regist.html" target="_blank">我要注册</a>

</body>
</html>