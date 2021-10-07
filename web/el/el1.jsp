<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/26
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="users.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>4}
${3+4}
${3/4}
<%
    request.setAttribute("name","李世民");
    session.setAttribute("age","16");
%>
${requestScope.name}
${sessionScope.age}
<%
    User user=new User();
    user.setName("李建成");
    user.setPassword("123456");
    request.setAttribute("u",user);
%>
${requestScope.u.name}
<c:set var="salary" scope="session" value="${4000}"/>
<c:choose>
    <c:when test="${salary<6000}">
        <h1>太惨了！！！</h1>
    </c:when>
    <c:when test="${salary>16000}">
        <h1>真不错！！！</h1>
    </c:when>

    <c:otherwise>
        什么都没有
    </c:otherwise>
</c:choose>
</body>
</html>
