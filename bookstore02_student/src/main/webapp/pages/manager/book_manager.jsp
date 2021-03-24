<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
    <link rel="stylesheet" href="static/css/bookManger.css" />
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function() {
        $(".del").click(function() {
          let title = $(this).prop("name");
          let rs = confirm("deleting <" + title +"> from the the database?");
          if (!rs) {
            return false;
          }
        });
        // jump to certain page
        $("#btnSub").click(function () {
          var pn = $("#pN").val();
          location.href = "BookServlet?method=getBooksByPage&pageNo=" + pn;
        });
      });

    </script>
  </head>
  <body>
    <div class="header">
      <div class="w">
        <div class="header-left">
          <a href="index.jsp">
            <img src="static/img/logo.gif" alt=""
          /></a>
          <h1>图书管理系统</h1>
        </div>
<%--        <div class="header-right">--%>
<%--          <a href="#" class="order">图书管理</a>--%>
<%--          <a href="pages/manager/order_manager.jsp" class="destory">订单管理</a>--%>
<%--          <a href="index.jsp" class="gohome">返回商城</a>--%>
<%--        </div>--%>
        <%@ include file="/WEB-INF/include/header.jsp"%>
      </div>
    </div>
    <div class="list">
      <div class="w">
        <div class="add">
          <a href="pages/manager/book_edit.jsp">add books</a>
        </div>
        <table>
          <thead>
            <tr>
              <th>picture</th>
              <th>bookname</th>
              <th>price</th>
              <th>author</th>
              <th>sales</th>
              <th>stock</th>
              <th>operation</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="book" items="${requestScope.page.list}">
            <tr>
              <td>
                <img src="${book.imgPath}" alt="" />
              </td>
              <td>${book.title}</td>
              <td>
                  ${book.price}
              </td>
              <td>${book.author}</td>
              <td>${book.sales}</td>
              <td>${book.stock}</td>
              <td>
                <a href="BookServlet?method=getBookById&id=${book.id}">change</a>
                <a name="${book.title}" href="BookServlet?method=deleteBookById&id=${book.id}" class="del">delete</a>
              </td>
            </tr>
<%--            <tr>--%>
<%--              <td>--%>
<%--                <img src="static/uploads/huozhe.jpg" alt="" />--%>
<%--              </td>--%>
<%--              <td>活着</td>--%>
<%--              <td>--%>
<%--                100.00--%>
<%--              </td>--%>
<%--              <td>余华</td>--%>
<%--              <td>200</td>--%>
<%--              <td>400</td>--%>
<%--              <td>--%>
<%--                <a href="pages/manager/book_edit.jsp">修改</a><a href="" class="del">删除</a>--%>
<%--              </td>--%>
<%--            </tr>--%>
          </c:forEach>
          </tbody>
        </table>
        <div class="footer">
          <div class="footer-right">
            <div><a href="BookServlet?method=getBooksByPage&pageNo=1">first page</a></div>
            <c:if test="${requestScope.page.pageNo>1}">
              <div><a href="BookServlet?method=getBooksByPage&pageNo=${requestScope.page.pageNo-1}">prev</a></div>
            </c:if>
<%--            <ul>--%>
<%--              <li class="active">1</li>--%>
<%--              <li>2</li>--%>
<%--              <li>3</li>--%>
<%--            </ul>--%>
            <c:if test="${requestScope.page.pageNo < requestScope.page.totalPageNo}">
              <div><a href="BookServlet?method=getBooksByPage&pageNo=${requestScope.page.pageNo+1}">next</a></div>
            </c:if>
            <div><a href="BookServlet?method=getBooksByPage&pageNo=${requestScope.page.totalPageNo}">last page</a></div>
            <span>${requestScope.page.pageNo}/${requestScope.page.totalPageNo} pages</span>
            <span>total ${requestScope.page.totalRecord} items</span>
            <span>No.</span>
            <input type="text" id="pN" value="${requestScope.page.pageNo}"/>
            <span>Page</span>
            <button id="btnSub">Confirm</button>
          </div>
        </div>
      </div>
    </div>
    <div class="bottom">
      <div class="w">
        <div class="top">
          <ul>
            <li>
              <a href="">
                <img src="static/img/bottom1.png" alt="" />
                <span>大咖级讲师亲自授课</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom.png" alt="" />
                <span>课程为学员成长持续赋能</span>
              </a>
            </li>
            <li>
              <a href="">
                <img src="static/img/bottom2.png" alt="" />
                <span>学员真是情况大公开</span>
              </a>
            </li>
          </ul>
        </div>
        <div class="content">
          <dl>
            <dt>关于尚硅谷</dt>
            <dd>教育理念</dd>
            <!-- <dd>名师团队</dd>
            <dd>学员心声</dd> -->
          </dl>
          <dl>
            <dt>资源下载</dt>
            <dd>视频下载</dd>
            <!-- <dd>资料下载</dd>
            <dd>工具下载</dd> -->
          </dl>
          <dl>
            <dt>加入我们</dt>
            <dd>招聘岗位</dd>
            <!-- <dd>岗位介绍</dd>
            <dd>招贤纳师</dd> -->
          </dl>
          <dl>
            <dt>联系我们</dt>
            <dd>http://www.atguigu.com</dd>
            <dd></dd>
          </dl>
        </div>
      </div>
<%--      <div class="down">--%>
<%--        尚硅谷书城.Copyright ©2015--%>
<%--      </div>--%>
      <%@ include file="/WEB-INF/include/footer.jsp"%>
    </div>
  </body>
</html>
