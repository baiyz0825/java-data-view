<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <link href="static/css/style_top.css" rel="stylesheet" type="text/css">
    <link href="static/css/book_detail_ad.css" rel="stylesheet" type="text/css">
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <title>期刊详情页</title>
</head>
<body>

<div class="toptip">
    <div class="toptip_logo"><a href="#" target="">
        <img height="40px" src="static/img/LIBAIlogo.png">
    </a></div>

    <div class="dropdown">
        <button class="img_user"><img src="static/img/user2.png"></button>
        <div class="dropdown-content">
            <!--      <a href="#">注册</a>-->
            <!--      <a href="#">登录</a>-->
            <a href="#">帮助？</a>
        </div>
    </div>
</div>

<div class="content">
    <div class="window">
        <form action="book/bookServlet" method="get">
            <table align="center" border="0">
                <tr>
                    <td class="book_img" rowspan="9"><img align="center" height="600px"
                                                          src="${pageScope.resourcesPath.concat(requestScope.book.src)}">
                    </td>
                    <td class="td_bookinform_title" colspan="2"><input id="name" name="name" type="text"
                                                                       value="${requestScope.book.name}">
                        <div style="border:1px solid #CCC "></div>
                    </td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="number"><strong>· 期刊ID编号:</strong></label></td>
                    <td class="td_rebookinform"><input id="number" name="number" type="text"
                                                       value="${requestScope.book.number}">
                    </td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="sortBook"><strong>· 期刊分类:</strong></label></td>
                    <td class="td_rebookinform"><input id="sortBook" name="sortBook" type="text"
                                                       value="${requestScope.book.sortBook}"></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="publisher"><strong> · 期刊出版社：</strong></label></td>
                    <td class="td_rebookinform"><input id="publisher" name="publisher" type="text"
                                                       value="${requestScope.book.publisher}">
                    </td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="author"><strong> · 期刊作者：</strong></label></td>
                    <td class="td_rebookinform"><input id="author" name="author" type="text"
                                                       value="${requestScope.book.author}"></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="publishData"><strong>· 期刊日期：</strong></label></td>
                    <td class="td_rebookinform"><input id="publishData" name="publishData" type="text"
                                                       value="${requestScope.book.publishData}">
                    </td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="prices"> <strong>· 期刊价格：</strong></label></td>
                    <td class="td_rebookinform"><input id="prices" name="prices" type="text"
                                                       value="${requestScope.book.prices}"></td>
                </tr>
                <tr>
                    <td class="td_bookinform"><label for="remainNumber"> <strong>· 期刊库存：</strong></label></td>
                    <td class="td_rebookinform"><input id="remainNumber" name="remainNumber" type="text"
                                                       value="${requestScope.book.remainNumber}">
                    </td>
                </tr>
                <tr>
                    <td class="td_confirm" colspan="2">
                        <input id="confirm" type="submit" value="确认"/>
                        <a id="cancel"
                           href="http://localhost:8088/JavaDataView/book/bookServlet?action=adminPages&pageNo=1&pageSize=6"
                           target="_self">取消</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%
    request.removeAttribute("book");
%>
</body>
</html>