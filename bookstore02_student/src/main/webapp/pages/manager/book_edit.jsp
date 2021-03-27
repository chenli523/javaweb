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
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function () {

        // changing auth code while clicking img
        // $("#imgCode").click(function () {
        //   // rand is for lower version browsers
        //   $(this).attr("src","KaptchaServlet?rand="+Math.random())
        // })


        //恢复提示框默认情况
        $(".errMess").css("visibility","hidden");
        // $("#authCodeMsg").css("visibility","visible");

        // username exists or not
        <%--var msg = "${requestScope.msg}"--%>
        <%--// if (msg == "null") {--%>
        <%--if (msg == "") {--%>
        <%--  $("#unMsg").css("visibility","hidden")--%>
        <%--} else {--%>
        <%--  $("#unMsg").css("visibility","visible");--%>
        <%--}--%>

        // //定义用户名&密码正则规则
        // var regUap = /^\w{6,18}$/;
        // /*
        //   验证用户名
        //  */
        // function checkUserName(){
        //   //获取用户名
        //   var username = $("#username").val();
        //   //验证用户名是否合法
        //   if(!regUap.test(username)){
        //     $("#unMsg").html("用户名只能是字母（大小写）、数字、_。6-18位").css("visibility","visible");
        //     return false;
        //   }else{
        //     $("#unMsg").css("visibility","hidden");
        //   }
        // }
        // /*
        //   验证密码
        //  */
        // function checkPwd(){
        //   //获取密码
        //   var pwdValue = $("#pwd").val();
        //   //获取确认密码
        //   var pwdRep = $("#pwdRep").val();
        //   if(!regUap.test(pwdValue)){
        //     $("#pwdMsg").css("visibility","visible");
        //     return false;
        //   }else{
        //     $("#pwdMsg").css("visibility","hidden");
        //     $("#pwdRepMsg").css("visibility","hidden");
        //   }
        // }
        //
        // /*
        //   验证确认密码
        //  */
        // function checkPwdRep(){
        //   //获取密码
        //   var pwd = $("#pwd").val();
        //   //获取确认密码
        //   var pwdRep = $("#pwdRep").val();
        //   if(pwd != pwdRep || !regUap.test(pwdValue)){
        //     $("#pwdRepMsg").css("visibility","visible");
        //     return false;
        //   }else{
        //     $("#pwdRepMsg").css("visibility","hidden");
        //     $("#pwdMsg").css("visibility","hidden");
        //   }
        //
        // }
        //
        // /*
        // 验证邮箱
        //  */
        // function checkEmail(){
        //   //获取邮箱
        //   var email = $("#email").val();
        //   //定义邮箱正则规则
        //   var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        //   if(!emailReg.test(email)){
        //     $("#emailMsg").css("visibility","visible");
        //     return false;
        //   }else{
        //     $("#emailMsg").css("visibility","hidden");
        //   }
        //
        // }
        //
        // //用户名change事件
        // $("#username").change(checkUserName);
        // //密码change事件
        // $("#pwd").change(checkPwd);
        // //确认密码change事件
        // $("#pwdRep").change(checkPwdRep);
        // //邮箱change事件
        // $("#email").change(checkEmail);
        //
        //
        // //注册单击事件
        // $("#btnSub").click(checkUserName);
        // $("#btnSub").click(checkPwd);
        // $("#btnSub").click(checkPwdRep);
        // $("#btnSub").click(checkEmail);

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
          <h1>Edit</h1>
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
            <span class="errMess" style="visibility: visible;">please enter a valid title</span>
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
