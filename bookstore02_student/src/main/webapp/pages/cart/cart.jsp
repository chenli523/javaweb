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
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function() {
        $("tbody td a").click(function() {
          let title = $(this).prop("name");
          let rs = confirm("Deleting <" + title +"> from the cart?");
          if (!rs) {
            return false;
          }
        });
        // click event for clearing the cart
        $(".footer .footer-left .clear-cart").click(function() {
          let rs = confirm("Clearing the cart?");
          if (!rs) {
            return false;
          }
        });
        // changing shopping items
        $(".count-num").change(function () {
          let bookId = $(this).attr("id");
          let newCount = $(this).val();
          let regEx = /^\+?[1-9][0-9]*$/;
          let deVal = this.defaultValue;
          if (regEx.test(newCount) == false) {
            $(this).val(deVal);
            alert("Positive numbers only");
            return false;
          }
          // location.href = "CartServlet?method=updateItemCount&count="+newCount+"&bookId="+bookId;
            let url = "CartServlet?method=updateItemCount";
            let data = {"bookId":bookId, "count":newCount};
            let $that = $(this).parent().next().next();
            $.getJSON(url, data,  function cb(rs) {
                $that.html(rs.amount)
                $("#totalCount").html(rs.totalCount)
                $("#totalAmount").html(rs.totalAmount)
            })
        })

        $("span[name='count-dec']").click(function () {
          let $input = $(this).next();
          let newCount = $input.val();
          let bookId = $input.attr("id");
          if(--newCount > 0) {
            $input.val(newCount);
            // location.href = "CartServlet?method=updateItemCount&count="+newCount+"&bookId="+bookId;
              let url = "CartServlet?method=updateItemCount";
              let data = {"bookId":bookId, "count":newCount};
              let $that = $(this).parent().next().next();
              $.getJSON(url, data,  function cb(rs) {
                  $that.html(rs.amount)
                  $("#totalCount").html(rs.totalCount)
                  $("#totalAmount").html(rs.totalAmount)
              })
          } else {
            location.href = "CartServlet?method=deleteItemById&&bookId="+bookId;
          }
        })

        $("span[name='count-inc']").click(function () {
          let $input = $(this).prev();
          let newCount = $input.val();
          let bookId = $input.attr("id");
          $input.val(++newCount);
          // location.href = "CartServlet?method=updateItemCount&count="+newCount+"&bookId="+bookId;
            let url = "CartServlet?method=updateItemCount";
            let data = {"bookId":bookId, "count":newCount};
            let $that = $(this).parent().next().next();
            $.getJSON(url, data,  function cb(rs) {
                $that.html(rs.amount)
                $("#totalCount").html(rs.totalCount)
                $("#totalAmount").html(rs.totalAmount)
            })
        })

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
          <h1>My Shopping Cart</h1>
        </div>
        <%@ include file="/WEB-INF/include/welcome.jsp"%>
<%--        <div class="header-right">--%>
<%--          <h3>??????<span>??????</span>?????????????????????</h3>--%>
<%--          <div class="order"><a href="pages/order/order.jsp">????????????</a></div>--%>
<%--          <div class="destory"><a href="index.jsp">??????</a></div>--%>
<%--          <div class="gohome">--%>
<%--            <a href="index.jsp">??????</a>--%>
<%--          </div>--%>
<%--        </div>--%>
      </div>
    </div>
    <c:if test="${empty sessionScope.cart.cartItems}">
      <div style="font-size: 25px; color: #666666;" align="center">Go Shopping!</div>
    </c:if>
    <c:if test="${not empty sessionScope.cart.cartItems}">
    <div class="list">
      <div class="w">
        <table>
          <thead>
            <tr>
              <th>Cover</th>
              <th>Product Name</th>

              <th>Quantity</th>
              <th>Price</th>
              <th>Amount</th>
              <th>Operations</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
            <tr>
              <td>
                <img src="${cartItem.book.imgPath}" alt="" />
              </td>
              <td>${cartItem.book.title}</td>
              <td>
                <span class="count" name="count-dec">-</span>
                <input class="count-num" id="${cartItem.book.id}" type="text" value="${cartItem.count}" />
                <span class="count" name="count-inc">+</span>
              </td>
              <td>${cartItem.book.price}</td>
              <td>${cartItem.amount}</td>
              <td><a name="${cartItem.book.title}" href="CartServlet?method=deleteItemById&bookId=${cartItem.book.id}">Delete</a></td>
            </tr>
          </c:forEach>
<%--            <tr>--%>
<%--              <td>--%>
<%--                <img src="static/uploads/kanjian.jpg" alt="" />--%>
<%--              </td>--%>
<%--              <td>??????</td>--%>
<%--              <td>--%>
<%--                <span class="count">-</span>--%>
<%--                <input class="count-num" type="text" value="1" />--%>
<%--                <span class="count">+</span>--%>
<%--              </td>--%>
<%--              <td>40.1</td>--%>
<%--              <td>40.1</td>--%>
<%--              <td><a href="">??????</a></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--              <td>--%>
<%--                <img src="static/uploads/kanjian.jpg" alt="" />--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                ?????????????????????,????????????????????????.?????????????????????--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                <span class="count">-</span>--%>
<%--                <input class="count-num" type="text" value="1" />--%>
<%--                <span class="count">+</span>--%>
<%--              </td>--%>
<%--              <td>40.1</td>--%>
<%--              <td>40.1</td>--%>
<%--              <td><a href="">??????</a></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--              <td>--%>
<%--                <img src="static/uploads/kanjian.jpg" alt="" />--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                ?????????????????????,????????????????????????.?????????????????????--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                <!-- <div> -->--%>
<%--                <span class="count">-</span>--%>
<%--                <input class="count-num" type="text" value="100" />--%>
<%--                <span class="count">+</span>--%>
<%--                <!-- </div> -->--%>
<%--              </td>--%>
<%--              <td>40.1</td>--%>
<%--              <td>40.1</td>--%>
<%--              <td><a href="">??????</a></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--              <td>--%>
<%--                <img src="static/uploads/kanjian.jpg" alt="" />--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                ?????????????????????,????????????????????????.?????????????????????--%>
<%--              </td>--%>
<%--              <td>--%>
<%--                <span class="count">-</span>--%>
<%--                <input class="count-num" type="text" value="99" />--%>
<%--                <span class="count">+</span>--%>
<%--              </td>--%>
<%--              <td>40.1</td>--%>
<%--              <td>40.1</td>--%>
<%--              <td><a href="">??????</a></td>--%>
<%--            </tr>--%>
          </tbody>
        </table>
        <div class="footer">
          <div class="footer-left">
            <a href="CartServlet?method=clearCart" class="clear-cart">Empty Cart</a>
            <a href="index.jsp">Continue Shopping</a>
          </div>
          <div class="footer-right">
            <div>Total<span id="totalCount">${sessionScope.cart.totalCount}</span> items</div>
            <div class="total-price">Total Amount $<span id="totalAmount">${sessionScope.cart.totalAmount}</span></div>
            <a class="pay" href="OrderServlet?method=checkOut">Check Out</a>
          </div>
        </div>
      </div>
    </div>
    </c:if>
    <div class="bottom">
      <div class="w">
        <%@ include file="/WEB-INF/include/footerTop.jsp"%>
<%--        <div class="top">--%>
<%--          <ul>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom1.png" alt="" />--%>
<%--                <span>???????????????????????????</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom.png" alt="" />--%>
<%--                <span>?????????????????????????????????</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--              <a href="">--%>
<%--                <img src="static/img/bottom2.png" alt="" />--%>
<%--                <span>???????????????????????????</span>--%>
<%--              </a>--%>
<%--            </li>--%>
<%--          </ul>--%>
<%--        </div>--%>
<%--        <div class="content">--%>
<%--          <dl>--%>
<%--            <dt>???????????????</dt>--%>
<%--            <dd>????????????</dd>--%>
<%--            <!-- <dd>????????????</dd>--%>
<%--            <dd>????????????</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>????????????</dt>--%>
<%--            <dd>????????????</dd>--%>
<%--            <!-- <dd>????????????</dd>--%>
<%--            <dd>????????????</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>????????????</dt>--%>
<%--            <dd>????????????</dd>--%>
<%--            <!-- <dd>????????????</dd>--%>
<%--            <dd>????????????</dd> -->--%>
<%--          </dl>--%>
<%--          <dl>--%>
<%--            <dt>????????????</dt>--%>
<%--            <dd>http://www.atguigu.com</dd>--%>
<%--            <dd></dd>--%>
<%--          </dl>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--      <div class="down">--%>
<%--        ???????????????.Copyright ??2015--%>
        <%@ include file="/WEB-INF/include/footer.jsp"%>
      </div>
    </div>
  </body>
</html>
