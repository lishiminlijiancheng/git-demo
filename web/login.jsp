<%--
  Created by IntelliJ IDEA.
  User: huawei
  Date: 2021/9/21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #main{
        width:400px;
        height:400px;
        border: blue solid 2px;
        border-radius: 10% 10% 10% 10%;
        margin: 0 auto;

    }
    #btn{
        margin-left:170px;
        background-color: blue;
        color: white;
        font-style: italic;
        font-weight: bolder;
    }
    input,p,span{
        margin-left:28px;
        margin-top: 20px;
    }
    table{
        padding: 5px;
        margin:15px;
    }
    .msg{
        margin-left: 20px;
        color: red;
    }
</style>
<body>
<div id="main">
    <form action="/loginServlet" method="post">
     <table>
         <tr>
             <td>用户名：</td>
             <td>
                 <input type="text" name="name">
             </td>
         </tr>
         <tr>
             <td>密码：</td>
             <td>
                 <input type="password" name="password">
             </td>
         </tr>
         <tr>
             <td>
                 验证码：
             </td>
             <td>
                 <input type="text" name="checkcode">
             </td>
         </tr>
         <tr>
             <td >
                 <img src="/demo8">
             </td>
             <td>
                 <a href="">看不清？换一张！</a>
             </td>
         </tr>
         <tr>
             <td colspan="2">
                 <input id="btn" type="submit" value="登录">
             </td>
         </tr>
     </table>
        <div class="msg"><%=request.getAttribute("cc_error")==null? " ":request.getAttribute("cc_error")%></div>
        <div class="msg"><%=request.getAttribute("login_error")==null? " ":request.getAttribute("login_error")%></div>

    </form>
</div>
<script>
    var a=document.getElementById("_a");
    var image=document.getElementById("image");
    a.onclick=function () { var time=new Date().getTime() ;
        image.src="/demo8?"+time;}
</script>

</body>
</html>
