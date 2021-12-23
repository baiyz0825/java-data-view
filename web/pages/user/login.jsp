<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/12
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <script type="text/javascript" src="static/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
    <link href="static/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet" type="text/css">
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <link href="static/css/style_top.css" rel="stylesheet" type="text/css">
    <script src="static/scripts/captchaFlush.js" type="text/javascript"></script>
    <title>登录</title>
</head>

<body>
<div class="toptip">
    <table>
        <tr>
            <td>首页logo<a href="#" target="-blank" title="首页Logo">
                <img src="">
            </a></td>
            <td class="img_user"><img src="static/img/user2.png"></td>
        </tr>
    </table>
</div>

<div class="content">
    <div class="con_wel">
        欢迎登录
    </div>
    <br/>
    <form action="user/userServlet" method="post">
        <input name="action" type="hidden" value="login">
        <table align="center" border="0">
            <tr>
                <td align="center" colspan="2">
                    <div class="alert-danger" style="background: none">
                        <strong>${empty requestScope.errorMsg ?"":requestScope.errorMsg}</strong>
                        </br>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="td_left"><label for="username">用户名：</label></td>
                <td class="td_right"><input id="username" name="name"
                                            placeholder="${empty requestScope.userName?"请输入学号或者工号":""}" type="text"
                                            value="${empty requestScope.userName?"":requestScope.userName}"></td>
            </tr>
            <tr>
                <td class="td_left"><label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label></td>
                <td class="td_right"><input id="password" name="password" placeholder="请输入密码" type="password"></td>
            </tr>
            <tr>
                <td class="td_left"><label>身&nbsp;&nbsp;&nbsp;&nbsp;份：</label></td>
                <td class="tdst_right"><input name="identity" type="radio" value="student">学生&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="identity" type="radio" value="administrator">管理员
                </td>
            </tr>
            <tr>
                <td class="td_left"><label for="checkCode">验证码：</label></td>
                <td class="tdst_right"><input id="checkCode" name="checkCode" placeholder="验证码" type="text">
                    <img id="img_check" src="captcha.jpg" alt="">
                </td>
            </tr>
            <tr>
                <td align="center" class="td_login" colspan="2"><input id="btn_sub" type="submit" value="立即登录"/>
                </td>
            </tr>
            <tr>
                <td class="td_left"></td>
                <td class="td_right"></td>
            </tr>
        </table>
    </form>
    <div class="href_register">
        <table>
            <tr>
                <td class="td_rgleft"><a href="pages/user/register.jsp" target="_self">马上注册</a></td>
                <td class="td_rgright"><a href="#" target="_self">忘记密码?</a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>