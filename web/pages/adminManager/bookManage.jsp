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
    <title>期刊管理</title>
</head>
<body>
<table>
    <tr>
        <td><a href="bookEdit.jsp">添加图书</a></td>
    </tr>
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
    <c:forEach items="${requestScope.page.pageData}" var="book">
        <tr>
            <td>${book.number}</td>
            <td>${book.name}</td>
            <td>${book.sortBook}</td>
            <td>${book.publisher}</td>
            <td>${book.author}</td>
            <td>${book.prices}</td>
            <td>${book.publishData}</td>
            <td>${book.remainNumber}</td>
            <td><a href="book/bookServlet?action=getBook&number=${book.number}">修改</a></td>
            <td><a class="confirmDelete"
                   href="book/bookServlet?action=delete&id=${book.number}&pageNo=${requestScope.page.pageNo}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <td> <!-- 当界面大于第一页显示首页和上一页-->
            <c:if test="${requestScope.page.pageNo > 1}">
                <a href="book/bookServlet?action=pages&pageNo=1">第一页</a>
                <a href="book/bookServlet?action=pages&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>
        </td>
        <td>
            <!-- 当界面小于最大页面，显示下一页和最后一页-->
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageCount}">
                <a href="book/bookServlet?action=pages&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="book/bookServlet?action=pages&pageNo=${requestScope.page.pageCount}">最后一页</a>
            </c:if>
        </td>
        <td>
            <%--        这里使用param对象获取地址栏中的参数Map<key,map>--%>
            <input id="inputPageNo" name="pageNo" value="${param.pageNo}"><label id="inputPageNoLabel"
                                                                                 for="inputPageNo">跳转</label>
            <script type="text/javascript">
                $(function () {//给label标签绑定单机事件
                    $("#inputPageNoLabel").click(function () {
                        let pageCount =${requestScope.page.pageCount};
                        // alert(pageCount);
                        let pageNo = $("#inputPageNo").val();//获取其标签Value属性值
                        // alert(location.href);//location。href显示当前浏览器的地址栏中的数据，赋值之后是在当前窗口或者父窗口打开地址
                        /* "top.location.href"是最外层的页面跳转
                         "window.location.href"、"location.href"是本页面跳转
                         "parent.location.href"是上一层页面跳转.*/
                        //边界检查
                        if (pageNo <= 1)
                            location.href = "${pageScope.basePath}book/bookServlet?action=pages&pageNo=1";
                        else if (pageNo >= pageCount)
                            location.href = "${pageScope.basePath}book/bookServlet?action=pages&pageNo=" + pageCount;
                        else
                            location.href = "${pageScope.basePath}book/bookServlet?action=pages&pageNo=" + pageNo;//在EL表达式中其获取域对象变为了pageScope->pageContext requestScope->Request sessionScope->Session applicationScope->ServletContext
                    })
                })
            </script>
        </td>
        <td>
            <div>总页数：${requestScope.page.pageCount}</div>
        </td>
        <td>
            <div>当前页：${requestScope.page.pageNo}</div>
        </td>
    </tr>
</table>
</body>
</html>
