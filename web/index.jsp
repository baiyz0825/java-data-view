<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <%@include file="pages/include/head.jsp" %>
    <script src="static/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
    <link href="static/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <link href="static/css/style_home.css" rel="stylesheet">
    <link href="static/css/style_top.css" rel="stylesheet">
    <script src="static/scripts/logout.js"></script>
    <title>首页</title>
</head>
<body>
<div class="toptip">
    <div class="toptip_logo"><a href="http://localhost:8088/JavaDataView/">
        <img src="static/img/LIBAIlogo.png" height="40px">
    </a></div>
    <div class="dropdown">
        <button class="img_user"><img src="static/img/user2.png"></button>
        <div class="dropdown-content">
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <a href="pages/user/login.jsp">登录</a>
                    <a href="pages/user/register.jsp">注册</a>
                </c:when>
                <c:when test="${sessionScope.user != null}">
                    <c:if test="${sessionScope.user.admin == 1}">
                        <a href="book/bookServlet?action=adminPages&pageNo=1&pageSize=6">管理期刊</a>
                    </c:if>
                    <!--在onClick事件中添加一个返回false既可以阻止元素的默认行为，并且当不配置href标签的#时其不会默认跳转top页面也就是当前地址栏后加一个#-->
                    <a href="" onclick="clickMouse();return false;">注销</a>
                </c:when>
            </c:choose>
            <a href="#">帮助？</a>
        </div>
    </div>
</div>

<div class="img_home">
    <img src="static/img/man.png" width=400px>
</div>

<div class="content">
    <form action="book/bookServlet" method="get">
        <input name="action" type="hidden" value="searchPages">
        <div class="con_frist">
            <table align="center" border="0">
                <tr>
                    <td class="td_top"><label for="name"><strong>期刊名称</strong></label></td>
                    <td class="td_top"><label for="sortBook"><strong>期刊种类</strong></label></td>
                    <td class="td_top"><label for="publisher"><strong>期刊出版社</strong></label></td>
                    <td class="td_top"><label for="author"><strong>期刊作者</strong></label></td>
                    <td class="td_top"><label for="publishData"><strong>出版时间</strong></label></td>

                </tr>
                <tr>
                    <td class="td_bottom"><input id="name" name="name" type="text" value=""></td>
                    <td class="td_bottom"><input id="sortBook" name="sortBook" type="text" value=""></td>
                    <td class="td_bottom"><input id="publisher" name="publisher" type="text" value=""></td>
                    <td class="td_bottom"><input id="author" name="author" type="text" value=""></td>
                    <td class="td_bottom"><input id="publishData" name="publishData" type="text" value=""></td>
                </tr>
            </table>
        </div>
        <div class="con_second">
            <table align="center" border="0">
                <tr>
                    <td align="center"><input id="btn_conf" type="submit" value="搜索"></td>
                </tr>
            </table>
        </div>
    </form>
</div>

<div class="box">
    <div class="imglist">
        <c:forEach items="${sessionScope.indexData}" var="book">
            <a href="book/bookServlet?action=getOneBookDetails&number=${book.number}">
                <img src="${pageScope.resourcesPath.concat(book.src)}" alt="${book.name}" width=210px>
            </a>
        </c:forEach>
        <%
            //更新页面信息之后删除Session域中存储的信息，方便刷新后再次获取
            session.removeAttribute("indexData");
        %>

        <%--        <img src="../static/img/book/Atlantis.jpg" width=199px>--%>
        <%--        <img src="../static/img/book/African%20Journal%20on%20Conflict%20Resolution.jpg" width=202px>--%>
        <%--        <img src="../static/img/book/Innovation.jpg" width=207px>--%>
        <%--        <img src="../static/img/book/Minority%20Translators%20Journal.jpg" width=208px>--%>
        <%--        <img src="../static/img/book/Songs%20Bimonthly.jpg" width=210px>--%>
        <%--        <img src="../static/img/book/Contemporary%20Artists.jpg" width=214px>--%>
        <%--        <img src="../static/img/book/Trends%20of%20Recent%20Researches%20on%20The%20History%20of%20China.jpg"--%>
        <%--             width=201px>--%>

        <%--        <img src="../static/img/book/XinJiang.jpg" width=210px>--%>
        <%--        <img src="../static/img/book/Chinese%20Theatre%20Arts.jpg" width=210px>--%>
        <%--        <img src="../static/img/book/Creation.jpg" width=210px>--%>
    </div>
</div>

</body>
</html>