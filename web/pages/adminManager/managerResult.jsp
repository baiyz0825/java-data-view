<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <link href="static/css/style_bottom.css" rel="stylesheet" type="text/css">
    <link href="static/css/style_top_search.css" rel="stylesheet" type="text/css">
    <link href="static/css/style_result_manager.css" rel="stylesheet" type="text/css">
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <script src="static/scripts/logout.js"></script>
    <script type="text/javascript">
        $(function () {//给label标签绑定单机事件
            $("#inputPageNoLabel").click(function () {
                let pageCount =${requestScope.page.pageCount};
                // alert(pageCount);
                let pageNo = $("#inputPageNo").val();//获取其标签Value属性值
                // alert(location.href);//location。href显示当前浏览器的地址栏中的数据，赋值之后是在当前窗口或者父窗口打开地址
                /* "top.location.href"是最外层的页面跳转
                 "window.location.href"、"location.href"是本页面跳转
                 "parent.location.href"是上一层页面跳转.*/
                //边界检查
                if (pageNo <= 1)
                    location.href = "${pageScope.basePath}book/bookServlet?action=adminPages&pageNo=1";
                else if (pageNo >= pageCount)
                    location.href = "${pageScope.basePath}book/bookServlet?action=adminPages&pageNo=" + pageCount;
                else
                    location.href = "${pageScope.basePath}book/bookServlet?action=adminPages&pageNo=" + pageNo;//在EL表达式中其获取域对象变为了pageScope->pageContext requestScope->Request sessionScope->Session applicationScope->ServletContext
            })
            $("a.confirmDelete").click(function () {
                //this为当前响应事件的dom对象，要使用jquery的函数，所以转换jquery的对象
                return confirm("你确认删除" + "\"" + $(this).parent().parent().find("td:eq(1)").text() + "\"" + "吗？");
                // return confirm("你确认删除"+"吗？");
            })
        })
    </script>
    <title>管理员</title>
</head>
<body>
<%--顶栏下拉框--%>
<div class="toptip">
    <div class="toptip_logo"><a href="#" target="">
        <img height="40px" src="static/img/LIBAIlogo.png" alt="">
    </a></div>
    <div class="toptip_search">
        <form action="book/bookServlet" method="get">
            <input name="action" type="hidden" value="searchPagesAdmin" style="display:none;">
            <table>
                <tr>
                    <td class="td_search"><label for="name"></label><input id="name" name="name" placeholder="期刊名称"
                                                                           type="text" value=""></td>
                    <td class="td_search"><label for="sortBook"></label><input id="sortBook" name="sortBook"
                                                                               placeholder="期刊分类" type="text" value="">
                    </td>
                    <td class="td_search"><label for="publisher"></label><input id="publisher" name="publisher"
                                                                                placeholder="期刊出版社" type="text"
                                                                                value=""></td>
                    <td class="td_search"><label for="author"></label><input id="author" name="author"
                                                                             placeholder="期刊作者" type="text" value="">
                    </td>
                    <td class="td_search"><label for="publishData"></label><input id="publishData" name="publishData"
                                                                                  placeholder="出版日期" type="text"
                                                                                  value=""></td>
                    <td align="center"><input id="btn_conf" type="submit" value="搜索"></td>
                </tr>
            </table>
        </form>
    </div>

    <div class="dropdown">
        <button class="img_user"><img src="static/img/user2.png" alt=""></button>
        <div class="dropdown-content">
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <a href="pages/user/login.jsp">登录</a>
                    <a href="pages/user/register.jsp">注册</a>
                </c:when>
                <c:when test="${sessionScope.user != null}">
                    <c:if test="${sessionScope.user.admin == 1}">
                        <a href="book/bookServlet?action=adminPages&pageNo=1&pageSize=6">管理期刊</a>
                        <a href="http://localhost:8088/JavaDataView/pages/adminManager/bookEdit.jsp">添加期刊</a>
                    </c:if>
                    <!--在onClick事件中添加一个返回false既可以阻止元素的默认行为，并且当不配置href标签的#时其不会默认跳转top页面也就是当前地址栏后加一个#-->
                    <a href="" onclick="clickMouse();return false;">注销</a>
                </c:when>
            </c:choose>
            <a href="pages/user/help.html">帮助？</a>
        </div>
    </div>
</div>
<%--主体--%>
<div class="content">
    <c:forEach items="${requestScope.page.pageData}" var="book" begin="0" end="2">
        <div class="con_book">
            <table align="" border="0">
                <tr>
                    <td class="td_bookimg" rowspan="8">
                        <img height="200px" src="${pageScope.resourcesPath.concat(book.src)}" alt="">
                    </td>
                    <td class="td_bookinform">
                        <label>期刊ID编号:</label>
                    </td>
                    <td class="td_rebookinform">
                        <span>${book.number}</span>
                    </td>
                    <td class="td_key" rowspan="8">
                        <p><a href="book/bookServlet?action=getBook&number=${book.number}">修改</a></p>
                        <p><a class="confirmDelete"
                              href="book/bookServlet?action=delete&id=${book.number}&pageNo=${requestScope.page.pageNo}&ImgPath=${book.src}">删除</a>
                        </p>
                    </td>
                </tr>

                <tr>
                    <td class="td_bookinform"><label>期刊名称:</label></td>
                    <td class="td_rebookinform"><span>${book.name}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>期刊分类:</label></td>
                    <td class="td_rebookinform"><span>${book.sortBook}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>期刊出版社:</label></td>
                    <td class="td_rebookinform"><span>${book.publisher}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>期刊作者:</label></td>
                    <td class="td_rebookinform"><span>${book.author}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>出版日期:</label></td>
                    <td class="td_rebookinform"><span>${book.publishData}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>期刊价格:</label></td>
                    <td class="td_rebookinform"><span>${book.prices}</span></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label>期刊库存:</label></td>
                    <td class="td_rebookinform"><span>${book.remainNumber}</span></td>
                </tr>
            </table>
        </div>
    </c:forEach>
</div>
<%--遮罩--%>
<div class="overlay"></div>
<%--页尾--%>
<div class="bottomtip">
    <table align="center" border="0">
        <tr>
            <!-- 当界面大于第一页显示首页和上一页-->
            <c:if test="${requestScope.page.pageNo > 1}">
                <td>
                    <button class="botton_key">
                        <a href="book/bookServlet?action=adminPages&pageNo=1">第一页</a>
                    </button>
                </td>
                <td>
                    <button class="botton_key">
                        <a href="book/bookServlet?action=adminPages&pageNo=${requestScope.page.pageNo-1}">上一页</a>
                    </button>
                </td>
            </c:if>
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageCount}">
                <!-- 当界面小于最大页面，显示下一页和最后一页-->
                <td>
                    <button class="botton_key">
                        <a href="book/bookServlet?action=adminPages&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                    </button>
                </td>
                <td>
                    <button class="botton_key">
                        <a href="book/bookServlet?action=adminPages&pageNo=${requestScope.page.pageCount}">最后一页</a>
                    </button>
                </td>
            </c:if>
            <td>
                <input id="inputPageNo" name="pageNo" value="${param.pageNo}">
            </td>
            <td>
                <label for="inputPageNo">
                    <button id="inputPageNoLabel" class="botton_key_jump">跳转</button>
                </label>
            </td>
            <td>
                <div class="num" style="font-size: 15px">当前页：${requestScope.page.pageNo}</div>
            </td>
            <td>
                <div class="num" style="font-size: 15px">总页数：${requestScope.page.pageCount}</div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
