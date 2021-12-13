<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="../include/head.jsp" %>
    <title>添加修改</title>

</head>
<body>
<div>修改图书信息</div>
<form action="book/bookServlet" method="get">
    <%--修改期刊时，需要回显，因此传入Servlet进行查询内容放入Req进行保存，之后由页面进行解析，因此发送参数含有number属性，
但是添加期刊不需要回显因此不存在number请求参数,所以，${empty param.number ? "addBook":"updateBook"} 如果其参数为空 empty 参数=>>>推出是空的=真！ 那么就是添加，否则修改--%>
    <input type="hidden" name="action" value="${empty param.number ? "addBook":"updateBook"}">
    <table class="table">
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
        <tr>
            <!--回显当前修改的期刊信息 当添加图书这个requestScope（request域）中不含book因此为空，当修改则是由servlet查找到当前图书信息放入request域中-->
            <td><input type="text" name="number" value="${requestScope.book.number}"></td>
            <td><input type="text" name="name" value="${requestScope.book.name}"></td>
            <td><input type="text" name="sortBook" value="${requestScope.book.sortBook}"></td>
            <td><input type="text" name="publisher" value="${requestScope.book.publisher}"></td>
            <td><input type="text" name="author" value="${requestScope.book.author}"></td>
            <td><input type="text" name="prices" value="${requestScope.book.prices}"></td>
            <td><input type="text" name="publishData" value="${requestScope.book.publishData}"></td>
            <td><input type="text" name="remainNumber" value="${requestScope.book.remainNumber}"></td>
            <td><input type="submit" value="确认"></td>
        </tr>
    </table>
</form>

</body>
</html>
