<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%
    //    获取=协议名称+服务器地址+服务器端口号+工程路径+"/"
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
    pageContext.setAttribute("basePath", basePath);//将服务器基地址确认存入pageContext中（也就是El表达式中的pageScope）
    System.out.println(basePath);
%>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%--导入Jqery--%>
<script type="text/javascript" src="static/scripts/jquery-1.7.2.js"></script>
<%--导入BootStrap--%>
<script type="text/javascript" src="static/bootstrap-5.1.3-dist/js/bootstrap.bundle.min.js"></script>
<link href="static/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet">
