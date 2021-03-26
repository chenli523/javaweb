<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>BookStore Membership Register</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
    <link rel="stylesheet" href="static/css/register.css" />
    <style type="text/css">
      .login_form {
        height: 420px;
        margin-top: 25px;
      }
    </style>
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript" >
        /*
            jQuery操作DOM【】
            visibility: hidden;  隐藏
            visibility: visible  显示
         */
        $(function () {

            // changing auth code while clicking img
            $("#imgCode").click(function () {
                // rand is for lower version browsers
                $(this).attr("src","KaptchaServlet?rand="+Math.random())
            })


            //恢复提示框默认情况
            $(".errMess").css("visibility","hidden");
            $("#authCodeMsg").css("visibility","visible");

            // username exists or not
            var msg = "${requestScope.msg}"
            // if (msg == "null") {
            if (msg == "") {
              $("#unMsg").css("visibility","hidden")
            } else {
              $("#unMsg").css("visibility","visible");
            }

            //定义用户名&密码正则规则
            var regUap = /^\w{6,18}$/;
            /*
              验证用户名
             */
            function checkUserName(){
                //获取用户名
                var username = $("#username").val();
                //验证用户名是否合法
                if(!regUap.test(username)){
                   $("#unMsg").html("用户名只能是字母（大小写）、数字、_。6-18位").css("visibility","visible");
                   return false;
                }else{
                   $("#unMsg").css("visibility","hidden");
                }
            }
            /*
              验证密码
             */
            function checkPwd(){
                //获取密码
                var pwdValue = $("#pwd").val();
                //获取确认密码
                var pwdRep = $("#pwdRep").val();
                if(!regUap.test(pwdValue)){
                  $("#pwdMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#pwdMsg").css("visibility","hidden");
                  $("#pwdRepMsg").css("visibility","hidden");
                }
            }

            /*
              验证确认密码
             */
            function checkPwdRep(){
                //获取密码
                var pwd = $("#pwd").val();
                //获取确认密码
                var pwdRep = $("#pwdRep").val();
                if(pwd != pwdRep || !regUap.test(pwdValue)){
                  $("#pwdRepMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#pwdRepMsg").css("visibility","hidden");
                  $("#pwdMsg").css("visibility","hidden");
                }

            }

            /*
            验证邮箱
             */
            function checkEmail(){
                //获取邮箱
                var email = $("#email").val();
                //定义邮箱正则规则
                var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!emailReg.test(email)){
                  $("#emailMsg").css("visibility","visible");
                  return false;
                }else{
                  $("#emailMsg").css("visibility","hidden");
                }

            }

            //用户名change事件
            $("#username").change(checkUserName);
            //密码change事件
            $("#pwd").change(checkPwd);
            //确认密码change事件
            $("#pwdRep").change(checkPwdRep);
            //邮箱change事件
            $("#email").change(checkEmail);


            //注册单击事件
            $("#btnSub").click(checkUserName);
            $("#btnSub").click(checkPwd);
            $("#btnSub").click(checkPwdRep);
            $("#btnSub").click(checkEmail);

        });

    </script>

  </head>
  <body>
    <div id="login_header">
      <a href="index.jsp">
        <img class="logo_img" alt="" src="static/img/logo.gif" />
      </a>
    </div>

    <div class="login_banner">
      <div class="register_form">
        <h1>register membership</h1>
        <form action="UserServlet">
<%--          for user servlet --%>
          <input type="hidden" name="method" value="regist">
          <div class="form-item">
            <div>
              <label>username:</label>
<%--              <input id="username" value="<%=request.getParameter("username") == null ? "" : request.getParameter("username")%>" name="username" type="text" placeholder="请输入用户名" />--%>
                <input id="username" value="${param.username}" name="username" type="text" placeholder="enter username" />
            </div>

              <span id="unMsg" class="errMess">${empty requestScope.msg ? "username can only be characters. numbers . _. 6-18 length" : requestScope.msg}</span>
<%--            <span id="unMsg" class="errMess"><%=request.getAttribute("msg") == null ? "用户名只能是字母（大小写）、数字、_。6-18位"  : request.getAttribute("msg")%></span>--%>
          </div>
          <div class="form-item">
            <div>
              <label>password:</label>
              <input id="pwd" name="pwd" type="password" placeholder="enter password" />
            </div>
            <span id="pwdMsg" class="errMess">password can only be characters. numbers . _. 6-18 length</span>
          </div>
          <div class="form-item">
            <div>
              <label>re-password:</label>
              <input id="pwdRep" type="password" placeholder="re-enter password" />
            </div>
            <span id="pwdRepMsg" class="errMess">passwords are different</span>
          </div>
          <div class="form-item">
            <div>
              <label>email:</label>
                <input id="email" value="${param.email}" name="email" type="text" placeholder="enter email" />
<%--              <input id="email" value="<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>" name="email" type="text" placeholder="请输入邮箱" />--%>
            </div>
            <span id="emailMsg" class="errMess">please enter valid email</span>
          </div>
          <div class="form-item">
            <div>
              <label>auth code:</label>
              <div class="verify">
                <input name="authCode" type="text" placeholder="" />
                <img id="imgCode" src="KaptchaServlet" alt="" width="100px" height="40px" />
              </div>
            </div>
            <span id="authCodeMsg" class="errMess">${requestScope.authCodeMsg}</span>
          </div>
          <button id="btnSub" class="btn">register</button>
        </form>
      </div>
    </div>
<%--    <div id="bottom">--%>
<%--      <span>--%>
<%--        尚硅谷书城.Copyright &copy;2015--%>
<%--      </span>--%>
<%--    </div>--%>
    <%@ include file="/WEB-INF/include/footer.jsp"%>
  </body>
</html>
