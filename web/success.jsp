<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/21
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    欢迎<%=request.getSession().getAttribute("username")%>
</h1>

</body>
</html>
