<%--
  Created by IntelliJ IDEA.
  User: 豆光耀
  Date: 2019/7/11
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>login.html</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>

<body>
<form action="admin/login">
    <div>账号:<input type="text" name="adminid"></input>
    </div>
    <div>密码:<input type="password" name="password"></input>
    </div>
    <input type="submit" value="登录"></input>
</form>
</body>
</html>

