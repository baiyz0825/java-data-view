<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <title>期刊信息管理系统</title>
</head>
<body>
<div>期刊信息管理系统</div>
<hr>
<div id="content">
    <form action="user/userServlet" method="post">
        <input type="hidden" name="action" value="login">
        <table align="center" border="0">
            <caption>欢迎登录</caption>
            <tr>
                <td><label for="username">用户名：</label></td>
                <td><input id="username" name="name" placeholder="学号/工号" type="text"></td>
            </tr>
            <tr>
                <td><label for="password">密码：</label></td>
                <td><input id="password" name="password" placeholder="密码" type="password"></td>
            </tr>
            <tr>
                <td><label>身&nbsp;&nbsp;&nbsp;&nbsp;份：</label></td>
                <td><input name="identity" type="radio" value="student">学生&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="identity" type="radio" value="administrator">管理员
                </td>
            </tr>
            <tr>
                <td><label for="checkCode">验证码：</label></td>
                <td><input id="checkCode" name="checkCode" placeholder="验证码" type="text">
                    <img src="#">
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="登录"/></td>
            </tr>
            <tr>
                <td align="center"><a href="#" target="_blank">立即注册</a></td>
                <td align="center"><a href="#" target="_blank">忘记密码?</a></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
