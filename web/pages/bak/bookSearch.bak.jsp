<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/11
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <title>搜索</title>
</head>
<body>
<form action="book/bookServlet" method="get">
    <input type="hidden" name="action" value="searchPages">
    <label for="inputNumber">期刊ISBN：
        <input id="inputNumber" type="text" name="number" value="">
    </label>
    <label for="inputName">期刊名称：
        <input id="inputName" type="text" name="name" value="">
    </label>
    <label for="inputAuthor">期刊作者：
        <input id="inputAuthor" type="text" name="author" value="">
    </label>
    <label for="inputSortBook">期刊分类：
        <input id="inputSortBook" type="text" name="sortBook" value="">
    </label>
    <label for="inputPublisher">期刊出版社：
        <input id="inputPublisher" type="text" name="publisher" value="">
    </label>
    <label for="InputPublishData">(暂时只能精准，日期范围不可用vvv)期刊出版日期：
        <input id="InputPublishData" type="text" name="publishData" value="">
    </label>
    <input type="submit" value="搜索">
</form>
</body>
</html>
