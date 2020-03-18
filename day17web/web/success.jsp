<%--
  Created by IntelliJ IDEA.
  User: qiuji
  Date: 2020/3/17
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("index")%></h1>
<h1><%=request.getSession().getAttribute("lastTime")%></h1>
<a href="/day17web/download.html">点我去下载</a>
</body>
</html>
