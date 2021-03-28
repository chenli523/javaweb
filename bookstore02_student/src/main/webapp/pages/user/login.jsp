<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>尚硅谷会员登录页面</title>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
          /**
           * 验证用户名
           * @returns {boolean}
           */
          function checkUserName(){
                //获取用户名
                var unValue = $("#username").val();
                if(unValue == ""){
                  alert("用户名不能为空，请重新输入！");
                  return false;
                }
            }

          /**
           * 验证密码
           */
          function checkPwd(){
            //获取密码
            var pwdValue = $("#password").val();
            if(pwdValue == ""){
              alert("密码不能为空，请重新输入！");
              return false;
            }
          }

          //实现登录页面，非空验证
          $("#sub_btn").click(checkUserName);
          $("#sub_btn").click(checkPwd);



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
      <div id="l_content">
        <span class="login_word">欢迎登录</span>
      </div>

      <div id="content">
        <div class="login_form">
          <div class="login_box">
            <div class="tit">
              <h1>尚硅谷会员</h1>
            </div>
            <div class="msg_cont">
              <b></b>
<%--                <span class="errorMsg"><%=request.getAttribute("msg")==null?"please enter username and password":request.getAttribute("msg")%></span>--%>
              <span class="errorMsg">${empty requestScope.msg ? "please enter username and password":requestScope.msg} </span>
            </div>
            <div class="form">
<%--              method 2--%>
              <form action="UserServlet?method=login" method="post">
<%--                method 1--%>
<%--                <input type="hidden" name="method" value="login">--%>
                <label>用户名称：</label>
                <input
                  class="itxt"
                  type="text"
                  placeholder="请输入用户名"
                  autocomplete="off"
                  tabindex="1"
                  name="username"
                  id="username"
                />
                <br />
                <br />
                <label>用户密码：</label>
                <input
                  class="itxt"
                  type="password"
                  placeholder="请输入密码"
                  autocomplete="off"
                  tabindex="1"
                  name="password"
                  id="password"
                />
                <br />
                <br />
                <input type="submit" value="Log In" id="sub_btn" />
              </form>
              <div class="tit">
                <a href="regist.jsp">立即注册</a>
              </div>
            </div>
          </div>
        </div>
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
