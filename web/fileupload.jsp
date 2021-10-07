<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/27
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/fileUpload_server" method="post" enctype="multipart/form-data">
    <input type="text" name="book_name">
    <input type="file" name="myFile">
    <input type="submit" value="上传">

</form>
</body>
</html>
