<%--
  Created by IntelliJ IDEA.
  User: a123
  Date: 3/25/21
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<c:if test="${empty sessionScope.user}">
    <div class="header-right">
<%--        <h3>欢迎<span>${sessionScope.user.username}</span>光临尚硅谷书城</h3>--%>
<%--        <div class="order"><a href="pages/order/order.jsp">我的订单</a></div>--%>
<%--        <div class="destory"><a href="index.jsp">注销</a></div>--%>
        <div class="gohome">
            <a href="index.jsp">Return</a>
        </div>
    </div>
</c:if>
<c:if test="${not empty sessionScope.user}">
    <div class="header-right">
        <h3>欢迎<span>${sessionScope.user.username}</span>Welcome to the BookStore</h3>
        <div class="order"><a href="pages/order/order.jsp">My Orders</a></div>
        <div class="destory"><a href="UserServlet?method=logOut">Log Out</a></div>
        <div class="gohome">
            <a href="index.jsp">Return</a>
        </div>
    </div>
</c:if>

