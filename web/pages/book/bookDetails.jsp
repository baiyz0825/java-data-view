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
        <form action="" method="get">
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
            <a href="#">注册</a>
            <a href="#">登录</a>
            <a href="#">帮助？</a>
        </div>
    </div>
</div>

<div class="content">
    <table align="center" border="0">
        <tr>
            <td class="book_img" rowspan="8"><img align="center" height="600px"
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
            <td class="td_rebookinform">${requestScope.book.remainNumber}</td>
        </tr>
    </table>
</div>

<%
    request.removeAttribute("book");
%>
</body>
</html>
