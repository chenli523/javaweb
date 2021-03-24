<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/style.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
    <link rel="stylesheet" href="static/css/bookManger.css" />
    <link rel="stylesheet" href="static/css/register.css" />
    <link rel="stylesheet" href="static/css/book_edit.css" />
  </head>
  <body>
    <div class="header">
      <div class="w">
        <div class="header-left">
          <a href="index.jsp">
            <img src="static/img/logo.gif" alt=""
          /></a>
          <h1>edit</h1>
        </div>
<%--        <div class="header-right">--%>
<%--          <a href="pages/manager/book_manager.jsp" class="order">图书管理</a>--%>
<%--          <a href="pages/manager/order_manager.jsp" class="destory">订单管理</a>--%>
<%--          <a href="index.jsp" class="gohome">返回商城</a>--%>
<%--        </div>--%>
        <%@ include file="/WEB-INF/include/header.jsp"%>
      </div>
    </div>
    <div class="login_banner">
      <div class="register_form">
        <form action="BookServlet?method=saveBook" method="post">
          <input type="hidden" value="${requestScope.book.id}" name="id">
          <div class="form-item">
            <div>
              <label>title:</label>
              <input name="title" type="text" value="${requestScope.book.title}" placeholder="please enter the title" />
            </div>
            <span class="errMess" style="visibility: visible;"
              >please enter a valid title</span
            >
          </div>
          <div class="form-item">
            <div>
              <label>price:</label>
              <input name="price" type="number" value="${requestScope.book.price}" placeholder="please enter the price" />
            </div>
            <span class="errMess">please enter a valid price</span>
          </div>
          <div class="form-item">
            <div>
              <label>author:</label>
              <input name="author" type="text" value="${requestScope.book.author}" placeholder="please enter the author name" />
            </div>
            <span class="errMess">please enter a valid author</span>
          </div>
          <div class="form-item">
            <div>
              <label>sales:</label>
              <input name="sales" type="number" value="${requestScope.book.sales}" placeholder="please enter the sales" />
            </div>
            <span class="errMess">please enter a valid sales</span>
          </div>
          <div class="form-item">
            <div>
              <label>stock:</label>
              <input name="stock" type="number" value="${requestScope.book.stock}" placeholder="please enter the stock" />
            </div>
            <span class="errMess">please enter a valid stock</span>
          </div>

          <button class="btn">submit</button>
        </form>
      </div>
    </div>
<%--    <div class="bottom">--%>
<%--      尚硅谷书城.Copyright ©2015--%>
<%--    </div>--%>
    <%@ include file="/WEB-INF/include/footer.jsp"%>
  </body>
</html>
