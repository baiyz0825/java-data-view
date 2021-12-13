<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/10
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <script type="text/javascript" src="static/scripts/registerVerify.js"></script>
    <script src="static/scripts/captchaFlush.js" type="text/javascript"></script>
    <title>注册</title>
    <span id="errorMsg">${empty requestScope.errorMsg?"":requestScope.errorMsg}</span>
    <form action="user/userServlet" method="post">
        <input type="hidden" name="action" value="register">
        <label>
            用户名：
            <input id="username" type="text" name="name" placeholder="${empty requestScope.username?"YourName":""}"
                   value="${empty requestScope.username?"":requestScope.username}">
        </label>
        <label>
            密码：
            <input id="password" type="text" name="password"
                   placeholder="${empty requestScope.password?"YourPassword":""}"
                   value="${empty requestScope.password?"":requestScope.password}">
        </label>
        <label>
            重复密码：
            <input id="passwordRepeat" type="text" name="password" value="">
        </label>
        <label>
            电话号码：
            <input id="number" type="text" name="number"
                   placeholder="${empty requestScope.username?"YourPhoneNumber":""}"
                   value="${empty requestScope.number?"":requestScope.number}">
        </label>
        <label>
            男：
            <input type="radio" name="sex" checked="checked" value="M">
        </label>
        <label>
            女：
            <input type="radio" name="sex" value="F">
        </label>
        <label>
            验证码：
            <input id="checkCode" type="text" name="checkCode" value="">
            <img id="img_check" src="captcha.jpg" alt="">
        </label>
        <input id="submitBtn" type="submit" placeholder="提交">
    </form>
</head>
<body>
</body>
</html>
