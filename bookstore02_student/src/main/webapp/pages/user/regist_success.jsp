<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membership Registration</title>
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
				<span class="wel_word"></span>
				<div>
					<span>welcome<span class="um_span">${sessionScope.user.username}</span>welcome to the bookstore</span>
					<a href="pages/order/order.jsp">my orders</a>
					<a href="index.jsp">log out</a>&nbsp;&nbsp;
					<a href="index.jsp">return</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>registered successfully! <a href="index.jsp">home</a></h1>
	
		</div>
		
<%--		<div id="bottom">--%>
<%--			<span>--%>
<%--				尚硅谷书城.Copyright &copy;2015--%>
<%--			</span>--%>
<%--		</div>--%>
		<%@ include file="/WEB-INF/include/footer.jsp"%>
</body>
</html>