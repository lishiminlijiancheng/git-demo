<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/17
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page import="jdbc_tool.*" %>
<%@page import="book_search.*" %>
<%@page import="com.microsoft.sqlserver.*"%>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    table{
        width:600px;
        height:200px;
        margin:50px;
        margin-left:300px;

    }
    td,th{
        padding:5px;
        text-align: center;
    }
    th{
        background-color:blue;
        color:white;
        font-weight: bolder;
        font-style: italic;
        font-size: 18px;
    }
    h1{
        text-align:center;
        background-color:blue;
        color:white;
        font-style: italic;
    }
</style>
<body>
<h1>欢迎来到星星书屋</h1>
<table border="1" cellspacing="0">
    <tr >
        <th>ID</th>
        <th>书名</th>
        <th>价格</th>
        <th>市场价</th>
        <th>出版社</th>
    </tr>
    <%ResultSet rs=search_helper.getAllTuple();

        try{while(rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString("title");
            double price=rs.getDouble(3);
            double market_price=rs.getDouble(4);
            String pub=rs.getString("pub");
            out.println("<tr>");
            out.println("<td>"+id+"</td>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+price+"</td>");
            out.println("<td>"+market_price+"</td>");
            out.println("<td>"+pub+"</td>");
            out.println("</tr>");
        }}
        catch(Exception e)
        {out.println("<h1>"+e+"</h1>");
        }%>
</table>
</body>
</html>
