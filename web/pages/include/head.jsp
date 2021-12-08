<%--
  Created by IntelliJ IDEA.
  User: byz08
  Date: 2021/12/8
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="static/scripts/jquery-1.7.2.js"></script>