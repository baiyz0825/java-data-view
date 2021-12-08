<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.confirmDelete").click(function () {
                //this为当前响应事件的dom对象，要使用jquery的函数，所以转换jquery的对象
                return confirm("你确认删除" + "\"" + $(this).parent().parent().find("td:eq(1)").text() + "\"" + "吗？");
                // return confirm("你确认删除"+"吗？");
            })
        })
    </script>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>期刊ID编号</td>
        <td>期刊名称</td>
        <td>期刊种类</td>
        <td>期刊出版社</td>
        <td>期刊作者</td>
        <td>期刊价格</td>
        <td>出版时间</td>
        <td>期刊库存</td>
        <td colspan="2"></td>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.number}</td>
            <td>${book.name}</td>
            <td>${book.sortBook}</td>
            <td>${book.publisher}</td>
            <td>${book.author}</td>
            <td>${book.prices}</td>
            <td>${book.publishData}</td>
            <td>${book.remainNumber}</td>
            <td><a href="bookEdit.jsp">修改</a></td>
            <td><a class="confirmDelete" href="book/bookServlet?action=delete&id=${book.number}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
