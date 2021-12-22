<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <script type="text/javascript" src="static/scripts/registerVerify.js"></script>
    <script src="static/scripts/captchaFlush.js" type="text/javascript"></script>
    <link href="static/css/style_register.css" rel="stylesheet" type="text/css">
    <%--    <script src="static/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>--%>
    <%--    <link href="static/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="static/img/title_book.ico" rel="shortcut icon" type="image/x">
    <link href="static/css/style_top.css" rel="stylesheet" type="text/css">
    <title>注册</title>
</head>

<body>
<div class="toptip">
    <div class="toptip_logo"><a href="#" target="">
        <img src="static/img/LIBAIlogo.png" height="40px">
    </a></div>
    <div class="dropdown">
        <button class="img_user"><img src="static/img/user2.png"></button>
        <div class="dropdown-content">
            <a href="#">帮助？</a>
        </div>
    </div>
</div>

<div class="content">
    <div class="con_wel">
        欢迎注册
    </div>
    <form action="user/userServlet" method="post">
        <input name="action" type="hidden" value="register">
        <table align="center" border="0">
            <tr>
                <td align="center" colspan="2">
                    <div class="alert-danger" style="background: none">
                        <strong id="errorMsg">${empty requestScope.errorMsg?"":requestScope.errorMsg}</strong>
                        </br>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="td_left"><label for="username">用户名：</label></td>
                <td class="td_right"><input id="username" name="name"
                                            placeholder="${empty requestScope.username?"YourName":""}"
                                            value="${empty requestScope.username?"":requestScope.username}" type="text">
                </td>
            </tr>
            <tr>
                <td class="td_left"><label for="number">手机号：</label></td>
                <td class="td_right"><input id="number" name="number"
                                            placeholder="${empty requestScope.username?"YourPhoneNumber":""}"
                                            value="${empty requestScope.number?"":requestScope.number}" type="tel"></td>
            </tr>
            <tr>
                <td class="td_left"><label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label></td>
                <td class="td_right"><input id="password" name="password"
                                            placeholder="${empty requestScope.password?"YourPassword":""}"
                                            value="${empty requestScope.password?"":requestScope.password}"
                                            type="password"></td>
            </tr>
            <tr>
                <td class="td_left"><label for="password_repeat">确&nbsp;&nbsp;&nbsp;&nbsp;定：</label></td>
                <td class="td_right"><input id="password_repeat" name="password" placeholder="RepeatYourPassword"
                                            type="password">
                </td>
            </tr>
            <tr>
                <td class="td_left"><label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label></td>
                <td class="tdst_right"><input name="sex" type="radio" value="M">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input name="sex" type="radio" value="F">女
                </td>
            </tr>
            <tr>
                <td class="td_left"><label for="checkCode">验证码：</label></td>
                <td class="td_right"><input id="checkCode" name="checkCode" placeholder="VerificationCode" type="text"
                                            value="">
                    <img id="img_check" src="captcha.jpg" width="100px">
                </td>
            </tr>
            <tr>
                <td align="center" class="td_login" colspan="2"><input id="btn_sub" type="submit" value="立即注册"/>
                </td>
            </tr>
        </table>
    </form>
    <div class="href_register">
        <table>
            <tr>
                <td class="td_rgright" colspan="2"><a href="pages/user/login.jsp" target="_blank">已注册?去登录</a></td>
            </tr>
        </table>
    </div>
</div>
<div class="overlay"></div>
</body>
</html>