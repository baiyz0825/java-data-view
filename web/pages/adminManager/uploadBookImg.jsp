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
    <link href="static/css/upload_bookimg.css" rel="stylesheet" type="text/css">
    <title>上传文件</title>
</head>
<body>
<div class="content">
    <div class="window">
        <form action="file/fileServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="number" value="${empty requestScope.BookImg.number ? "":requestScope.BookImg.number}">
            <input type="hidden" name="src" value="${empty requestScope.BookImg.src ? "":requestScope.BookImg.src}">
            <div class="con_text">

                <h2>您要上传的&nbsp${empty requestScope.BookImg.name ? "":requestScope.BookImg.name}封面图片：</h2>
                <p><input id="image" name="image" type="file" value="选择文件"></p>
                <p><input id="submit" name="submit" type="submit" value="确认提交">
                    <a id="cancel" href="javascript:" onclick="self.location=document.referrer;">取消</a>
                </p>

            </div>
        </form>
    </div>
</div>

</body>
</html>
