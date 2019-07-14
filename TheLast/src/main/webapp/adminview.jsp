<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 豆光耀
  Date: 2019/7/11
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>管理员视图</title>
</head>
<body>
<div>

    <form action="findDocById">
        档案编码：<input type="text" name="docId">
        <input type="submit" value="查询">
    </form>
    <form action="findByManyCondition">
        审核状态：<input type="text" name="doc_check_status">
        档案状态：<input type="text" name="doc_status">
        建档时间：<input type="text" name="start_time">//?起始时间
        至：<input type="text" name="end_time">//?结束时间
        <input type="submit" value="查询">
    </form>

</div>



<table border="1" cellspacing="0">
    <tr>        <td>档案编码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>所属部门</td>
        <td>职位</td>
        <td>建档日期</td>
        <td>审核状态</td>
        <td>档案状态</td>
        <td>操作</td>
    </tr>
    <c:forEach var="doc" items="${allDocVoList}">

        <tr>
            <td>${doc.id}</td>
            <td>${doc.e_name}</td>
            <td>${doc.e_sex}</td>
            <td>${doc.e_sector_name}</td>
            <td>${doc.e_position}</td>
            <td>${doc.e_register_date}</td>
            <td>${doc.doc_check_status}</td>
            <td>${doc.doc_status}</td>
            <td><a href="updateDocBut?docid=${doc.id}">修改</a>
                <a href="oneDocView?docid=${doc.id}">明细</a>
                <a href="delDoc?docid=${doc.id}&check_status=${doc.doc_check_status}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
