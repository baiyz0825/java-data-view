<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/19
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
    <link href="static/css/style_top_search.css" rel="stylesheet" type="text/css">
    <link href="static/css/style_book_detail.css" rel="stylesheet" type="text/css">
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <title>期刊详情</title>
</head>
<body>
<div class="toptip">
    <div class="toptip_logo"><a href="#" target="">
        <img height="40px" src="static/img/LIBAIlogo.png">
    </a></div>
    <div class="toptip_search">
        <form action="book/bookServlet" method="get">
            <input name="action" type="hidden" value="searchPages">
            <table align="center">
                <tr>
                    <td class="td_search"><input id="name" name="name" placeholder="期刊名称" type="text" value=""></td>
                    <td class="td_search"><input id="sortBook" name="sortBook" placeholder="期刊分类" type="text" value="">
                    </td>
                    <td class="td_search"><input id="publisher" name="publisher" placeholder="期刊出版社" type="text"
                                                 value=""></td>
                    <td class="td_search"><input id="author" name="author" placeholder="期刊作者" type="text" value=""></td>
                    <td class="td_search"><input id="publishData" name="publishData" placeholder="出版日期" type="text"
                                                 value=""></td>
                    <td align="center"><input id="btn_conf" type="submit" value="搜索"></td>
                </tr>
            </table>
        </form>
    </div>

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

<div class="content">
    <div class="window">
        <table align="center" border="0">
            <tr>
                <td class="book_img" rowspan="8"><img align="center" height="600px" width="425px"
                                                      src="${pageScope.resourcesPath.concat(requestScope.book.src)}"
                                                      alt="${requestScope.book.name}"></td>
                <td class="td_bookinform_title" colspan="2"><span>${requestScope.book.name}</span>
                    <div style="border:1px solid #CCC "></div>
                </td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊ID编号:</strong></td>
                <td class="td_rebookinform">ISBN: ${requestScope.book.number}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊分类:</strong></td>
                <td class="td_rebookinform">${requestScope.book.sortBook}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊出版社：</strong></td>
                <td class="td_rebookinform">${requestScope.book.publisher}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊作者：</strong></td>
                <td class="td_rebookinform">${requestScope.book.author}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊日期：</strong></td>
                <td class="td_rebookinform">${requestScope.book.publishData}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊价格：</strong></td>
                <td class="td_rebookinform">${requestScope.book.prices}</td>
            </tr>
            <tr>
                <td class="td_bookinform"><strong>· 期刊库存：</strong></td>
                <td class="td_rebookinform">${requestScope.book.remainNumber}
                    <a href="#">返回</a>
                </td>
            </tr>
        </table>
    </div>
</div>

<%
    request.removeAttribute("book");
%>
</body>
</html>
