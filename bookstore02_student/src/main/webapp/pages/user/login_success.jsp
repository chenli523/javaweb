<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@ include file="/WEB-INF/include/base.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<a href="index.jsp">
					<img class="logo_img" alt="" src="static/img/logo.gif" />
				</a>
				<div>
					<span>Welcome<span class="um_span">${sessionScope.user.username}</span>to the BookStore</span>
					<a href="pages/order/order.jsp">my order</a>
					<a href="UserServlet?method=logOut">Log Out</a>
					<a href="index.jsp">Return</a>
				</div>
		</div>
		
		<div id="main">

<%--			<h1>Welcome Back <a href="UserServlet?method=logInSuccess">go to home</a></h1>--%>
				<h1>Welcome Back <a href="index.jsp">go to home</a></h1>
	
		</div>
		
<%--		<div id="bottom">--%>
<%--			<span>--%>
<%--				尚硅谷书城.Copyright &copy;2015--%>
<%--			</span>--%>
<%--		</div>--%>
		<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>