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
    <title>期刊详情</title>
</head>
<body>
<h1>期刊详情：</h1>
<span>期刊名称：${requestScope.book.name}</span>
<span>期刊作者：${requestScope.book.author}</span>
<span>期刊出版社：${requestScope.book.publisher}</span>
<span>期刊出版时间：${requestScope.book.publishData}</span>
<span>期刊价格：${requestScope.book.prices}</span>
<span>期刊图片：<img src=" ${pageScope.resourcesPath.concat(requestScope.book.src)}" alt="${requestScope.book.name}"
                width=210px></span>
<%
    request.removeAttribute("book");
%>
</body>
</html>
