<%--
  Created by IntelliJ IDEA.
  User: a123
  Date: 3/22/21
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BookStore Home</title>
    <%--    <base href="<%=request.getContextPath()%>/">--%>
    <%@ include file="/WEB-INF/include/base.jsp"%>
    <link rel="stylesheet" href="static/css/minireset.css" />
    <link rel="stylesheet" href="static/css/common.css" />
    <link rel="stylesheet" href="static/css/iconfont.css" />
    <link rel="stylesheet" href="static/css/index.css" />
    <link rel="stylesheet" href="static/css/swiper.min.css" />
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function() {

            // jump to certain page
            // $("#btnSub").click(function () {
            //     let pn = $("#pN").val();
            //     let minPrice = $("#minPrice").val();
            //     let maxPrice = $("#maxPrice").val();
            //     location.href = "BookClientServlet?method=getBooksByPageAndPrice&pageNo=" + pn + "&minPrice=" +minPrice+"&maxPrice="+maxPrice;
            // });
            // search with a price range
            $("#btnSub, .price-search button").click(function() {
                let pNum = $("#pN").val();
                let minPrice = $("#minPrice").val();
                let maxPrice = $("#maxPrice").val();
                location.href = "BookClientServlet?method=getBooksByPageAndPrice&pageNo=" + pNum + "&minPrice=" +minPrice+"&maxPrice="+maxPrice;
            });
            // add book to the cart
            $(".list-content button").click(function () {
                let bookId = $(this).attr("id");
                location.href = "CartServlet?method=addBook&bookId=" + bookId;
            })
        });
    </script>
</head>
<body>
<div id="app">
    <div class="topbar">
        <div class="w">
            <div class="topbar-left">
                <i>Location:</i>
                <i>Los Angeles</i>
                <i class="iconfont icon-ai-arrow-down"></i>
            </div>
            <div class="topbar-right">
                <a href="pages/user/login.jsp" class="login">Log In</a>
                <a href="pages/user/regist.jsp" class="register">Sign Up</a>
<%--                <c:if test="not empty ${sessionScope.user.username}">--%>
                    <a href="pages/cart/cart.jsp" class="cart iconfont icon-gouwuche">
                        Cart
                        <c:if test="${not empty sessionScope.cart.totalCount and sessionScope.cart.totalCount > 0}">
                            <div class="cart-num">${sessionScope.cart.totalCount}</div>
                        </c:if>
                    </a>
<%--                </c:if>--%>
<%--                ${sessionScope.user.username}--%>
                <a href="BookServlet?method=getBooksByPage&pageNo=1" class="admin">Backstage Management</a>
            </div>
            <!--          登录后风格-->
            <!--          <div class="topbar-right">-->
            <!--            <span>欢迎你<b>张总</b></span>-->
            <!--            <a href="#" class="register">注销</a>-->
            <!--            <a-->
            <!--                    href="pages/cart/cart.jsp"-->
            <!--                    class="cart iconfont icon-gouwuche-->
            <!--			">-->
            <!--              购物车-->
            <!--              <div class="cart-num">3</div>-->
            <!--            </a>-->
            <!--            <a href="pages/manager/book_manager.jsp" class="admin">后台管理</a>-->
            <!--          </div>-->
        </div>
    </div>
    <div class="header w">
        <a href="#" class="header-logo"></a>
        <div class="header-nav">
            <ul>
                <li><a href="#">java</a></li>
                <li><a href="#">前端</a></li>
                <li><a href="#">小说</a></li>
                <li><a href="#">文学</a></li>
                <li><a href="#">青春文学</a></li>
                <li><a href="#">艺术</a></li>
                <li><a href="#">管理</a></li>
            </ul>
        </div>
        <div class="header-search">
            <input type="text" placeholder="十万个为什么" />
            <button class="iconfont icon-search"></button>
        </div>
    </div>
    <div class="banner w clearfix">
        <div class="banner-left">
            <ul>
                <li>
                    <a href="">
                        <span>文学 鉴赏</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>社科 研究</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>少儿 培训</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>艺术 赏析</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>生活 周边</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>文教 科技</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
                <li>
                    <a href="">
                        <span>热销 畅读</span>
                        <i class="iconfont icon-jiantou"></i
                        ></a>
                </li>
            </ul>
        </div>
        <div class="banner-right">
            <div class="swiper-container">
                <ul class="swiper-wrapper">
                    <li class="swiper-slide">
                        <img src="static/uploads/banner4.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                    <li class="swiper-slide">
                        <img src="static/uploads/banner5.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                    <li class="swiper-slide">
                        <img src="static/uploads/banner6.jpg" alt="">
                        <!-- <div class="banner-img"></div> -->
                    </li>
                </ul>
                <div class="swiper-button-prev"></div>

                <div class="swiper-button-next"></div>

                <!-- Add Pagination -->
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>
    <div class="books-list ">
        <div class="w">
            <div class="list">
                <div class="list-header">
                    <div class="title">Book List</div>
                    <div class="price-search">
                        <span>price: $</span>
                        <input type="text" id="minPrice" value="${param.minPrice}">
                        <span>-$</span>
                        <input type="text" id="maxPrice" value="${param.maxPrice}">
                        <span></span>
                        <button>search</button>
                    </div>
                </div>
                <div class="list-content">
                    <c:forEach items="${requestScope.page.list}" var="book">
                        <div class="list-item">
                            <img src="${book.imgPath}" alt="">
                            <p>title:${book.title}</p>
                            <p>author:${book.author}</p>
                            <p>price:$${book.price}</p>
                            <p>sales:${book.sales}</p>
                            <p>stock:${book.stock}</p>
                            <button id="${book.id}">add to cart</button>
                        </div>
                    </c:forEach>
                </div>
<%--                changable variables begin and end --%>
                <c:choose>
                    <c:when test="${requestScope.page.totalPageNo<5}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="${requestScope.page.totalPageNo}"></c:set>
                    </c:when>
                    <c:when test="${requestScope.page.pageNo<=3}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="5"></c:set>
                    </c:when>
                    <c:when test="${requestScope.page.pageNo>3 && requestScope.page.pageNo <= requestScope.page.totalPageNo-2}">
                        <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                        <c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="${requestScope.page.totalPageNo-4}"></c:set>
                        <c:set var="end" value="${requestScope.page.totalPageNo}"></c:set>
                    </c:otherwise>
                </c:choose>
                <div class="list-footer">
                    <div><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=1&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">first page</a></div>
                    <c:if test="${requestScope.page.pageNo>1}">
                        <div><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${requestScope.page.pageNo-1}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">prev</a></div>
                    </c:if>
                    <ul>
                        <c:forEach var="num" begin="${begin}" end="${end}">
                            <c:if test="${requestScope.page.pageNo==num}">
                                <li class="active"><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${num}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">${num}</a></li>
                            </c:if>
                            <c:if test="${requestScope.page.pageNo!=num}">
                                <li><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${num}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">${num}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                    <c:if test="${requestScope.page.pageNo < requestScope.page.totalPageNo}">
                        <div><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${requestScope.page.pageNo+1}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">next</a></div>
                    </c:if>
                    <div><a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${requestScope.page.totalPageNo}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}">last page</a></div>
                    <span>${requestScope.page.pageNo}/${requestScope.page.totalPageNo} pages</span>
                    <span>total ${requestScope.page.totalRecord} items</span>
                    <span>No.</span>
                    <input type="text" id="pN" value="${requestScope.page.pageNo}"/>
                    <span>Page</span>
                    <button id="btnSub">Confirm</button>

<%--                    <div>首页</div>--%>
<%--                    <div>上一页</div>--%>
<%--                    <ul><li class="active">1</li><li>2</li><li>3</li></ul>--%>
<%--                    <div>下一页</div>--%>
<%--                    <div>末页</div>--%>
<%--                    <span>共10页</span>--%>
<%--                    <span>30条记录</span>--%>
<%--                    <span>到第</span>--%>
<%--                    <input type="text">--%>
<%--                    <span>页</span>--%>
<%--                    <button>确定</button>--%>
                </div>
            </div>
        </div>

    </div>
    <div class="cate w">
        <div class="list">
            <a href="" class="list-item">
                <i class="iconfont icon-java"></i>
                <span>java</span>
            </a>
            <a href="" class="list-item"
            ><i class="iconfont icon-h5"></i>h5</a
            >
            <a href="" class="list-item">
                <i class="iconfont icon-python"></i>python
            </a>
            <a href="" class="list-item"
            ><i class="iconfont icon-tianchongxing-"></i>pm</a
            >
            <a href="" class="list-item"
            ><i class="iconfont icon-php_elephant"></i>php</a
            >
            <a href="" class="list-item"
            ><i class="iconfont icon-go"></i>go</a
            >
        </div>
        <a href="" class="img">
            <img src="static/uploads/cate4.jpg" alt="" />
        </a>
        <a href="" class="img">
            <img src="static/uploads/cate5.jpg" alt="" />
        </a>
        <a href="" class="img">
            <img src="static/uploads/cate6.jpg" alt="" />
        </a>
    </div>
    <div class="books">
        <div class="w">
            <div class="seckill">
                <div class="seckill-header">
                    <div class="title">
                        图书秒杀
                    </div>
                    <!-- <i class="iconfont icon-huanyipi"></i> -->
                </div>
                <div class="seckill-content">

                    <a href="" class="tip">
                        <h5>距离结束还有</h5>
                        <i class="iconfont icon-shandian"></i>
                        <div class="downcount">
                            <span class="time">00</span>
                            <span class="token">:</span>
                            <span class="time">00</span>
                            <span class="token">:</span>
                            <span class="time">00</span>
                        </div>
                    </a>


                    <a href="" class="books-sec">
                        <img src="static/uploads/congwanqingdaominguo.jpg" alt="">
                        <p>从晚晴到民国</p>
                        <div>
                            <span class="cur-price">￥28.9</span>
                            <span class="pre-price">￥36.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/cyuyanrumenjingdian.jpg" alt="">
                        <p>c语言入门经典</p>
                        <div>
                            <span class="cur-price">￥55.9</span>
                            <span class="pre-price">￥68.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/fusang.jpg" alt="">
                        <p>扶桑</p>
                        <div>
                            <span class="cur-price">￥30.9</span>
                            <span class="pre-price">￥47.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>
                    <a href="" class="books-sec">
                        <img src="static/uploads/geihaizideshi.jpg" alt="">
                        <p>给孩子的诗</p>
                        <div>
                            <span class="cur-price">￥18.9</span>
                            <span class="pre-price">￥25.5</span>
                        </div>
                        <button>立即购买</button>
                    </a>




                    </ul>
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
                            <img src="static/img/bottom1.png" alt="">
                            <span>大咖级讲师亲自授课</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="static/img/bottom.png" alt="">
                            <span>课程为学员成长持续赋能</span>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="static/img/bottom2.png" alt="">
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
                    <dd>http://www.atguigu.com<dd>
                </dl>
            </div>
        </div>
        <%@ include file="/WEB-INF/include/footer.jsp"%>
<%--        <div class="down">--%>
<%--            尚硅谷书城.Copyright ©2015--%>
<%--        </div>--%>
    </div>


</div>
<script src="static/script/swiper.min.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        autoplay: true,
        pagination: {
            el: '.swiper-pagination',
            dynamicBullets: true
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev'
        }
    })
</script>
</body>
</html>
