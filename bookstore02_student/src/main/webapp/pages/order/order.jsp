<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>My Order</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/cart.css" />
    <link rel="stylesheet" href="static/css/bookManger.css" />
    <link rel="stylesheet" href="static/css/orderManger.css" />
  </head>
  <body>
    <div class="header">
      <div class="w">
        <div class="header-left">
          <a href="index.jsp">
            <img src="static/img/logo.gif" alt=""
          /></a>
          <h1>My Order</h1>
        </div>
        <%@ include file="/WEB-INF/include/welcome.jsp"%>
<%--        <div class="header-right">--%>
<%--          <h3>欢迎<span>张总</span>光临尚硅谷书城</h3>--%>
<%--          <div class="order"><a href="pages/order/order.jsp">我的订单</a></div>--%>
<%--          <div class="destory"><a href="index.jsp">注销</a></div>--%>
<%--          <div class="gohome">--%>
<%--            <a href="index.jsp">返回</a>--%>
<%--          </div>--%>
<%--        </div>--%>
      </div>
    </div>
    <div class="list">
      <div class="w">
        <%@ include file="/WEB-INF/include/footerTop.jsp"%>
<%--        <table>--%>
<%--          <thead>--%>
<%--            <tr>--%>
<%--              <th>Order Number</th>--%>
<%--              <th>Order Date</th>--%>
<%--              <th>Order Amount</th>--%>
<%--              <th>Order Count</th>--%>
<%--              <th>Order State</th>--%>
<%--              <th>Order Detail</th>--%>
<%--            </tr>--%>
<%--          </thead>--%>
<%--          <tbody>--%>
<%--            <tr>--%>
<%--              <td>12354456895</td>--%>
<%--              <td>--%>
<%--                2015.04.23--%>
<%--              </td>--%>
<%--              <td>90.00</td>--%>
<%--              <td>88</td>--%>
<%--              <td><a href="" class="send">preparing</a></td>--%>
<%--              <td><a href="">details</a></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--              <td>12354456895</td>--%>
<%--              <td>--%>
<%--                2015.04.23--%>
<%--              </td>--%>
<%--              <td>90.00</td>--%>
<%--              <td>88</td>--%>
<%--              <td><a href="" class="send">preparing</a></td>--%>
<%--              <td><a href="">details</a></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--              <td>12354456895</td>--%>
<%--              <td>--%>
<%--                2015.04.23--%>
<%--              </td>--%>
<%--              <td>90.00</td>--%>
<%--              <td>88</td>--%>
<%--              <td><a href="" class="send">sent out</a></td>--%>
<%--              <td><a href="">details</a></td>--%>
<%--            </tr>--%>
<%--          </tbody>--%>
<%--        </table>--%>
<%--        <div class="footer">--%>
<%--          <div class="footer-right">--%>
<%--            <div>First Page</div>--%>
<%--            <div>Prev</div>--%>
<%--            <ul>--%>
<%--              <li class="active">1</li>--%>
<%--              <li>2</li>--%>
<%--              <li>3</li>--%>
<%--            </ul>--%>
<%--            <div>Next</div>--%>
<%--            <div>Last Page</div>--%>
<%--            <span>Total 10 Pages</span>--%>
<%--            <span>30 Records</span>--%>
<%--            <span>To</span>--%>
<%--            <input type="text" />--%>
<%--            <span>Page</span>--%>
<%--            <button>Confirm</button>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--    <div class="bottom">--%>
<%--      <div class="w">--%>
<%--        <div class="top">--%>
<%--          <ul>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom1.png" alt="" />--%>
<%--                <span>大咖级讲师亲自授课</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom.png" alt="" />--%>
<%--                <span>课程为学员成长持续赋能</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom2.png" alt="" />--%>
<%--                <span>学员真是情况大公开</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--          </ul>--%>
<%--        </div>--%>
<%--        <div class="content">--%>
<%--          <dl>--%>
<%--            <dt>关于尚硅谷</dt>--%>
<%--            <dd>教育理念</dd>--%>
<%--            <!-- <dd>名师团队</dd>--%>
<%--            <dd>学员心声</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>资源下载</dt>--%>
<%--            <dd>视频下载</dd>--%>
<%--            <!-- <dd>资料下载</dd>--%>
<%--            <dd>工具下载</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>加入我们</dt>--%>
<%--            <dd>招聘岗位</dd>--%>
<%--            <!-- <dd>岗位介绍</dd>--%>
<%--            <dd>招贤纳师</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>联系我们</dt>--%>
<%--            <dd>http://www.atguigu.com</dd>--%>
<%--            <dd></dd>--%>
<%--          </dl>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--      <div class="down">--%>
<%--        尚硅谷书城.Copyright ©2015--%>
<%--      </div>--%>
      <%@ include file="/WEB-INF/include/footer.jsp"%>
    </div>
  </body>
</html>
