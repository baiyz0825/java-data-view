<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/19
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
    <title>Title</title>
</head>
<body>
<form action="file/fileServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="number" value="${empty requestScope.BookImg.number ? "":requestScope.BookImg.number}">
    <input type="hidden" name="src" value="${empty requestScope.BookImg.src ? "":requestScope.BookImg.src}">
    您要上传的${empty requestScope.BookImg.name ? "":requestScope.BookImg.name}封面图片：<input name="image" type="file" value="">
    <input type="submit" value="确认提交">
</form>
</body>
</html>
