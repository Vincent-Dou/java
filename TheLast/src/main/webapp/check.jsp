<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
 人事管理录入系统
  <body>

   <form action="admin/addDoc">
   	<div> 姓名：<input type="text" name ="e_name"></input>  性别：<input type="text" name="e_sex"></input></div>
   	<div> 职位名称：<input type="text" name ="e_position"></input>  文档编码：<input type="text" name="doc_no"></div>
   	<div> 档案状态：<input type="text" name="doc_status"></input></div>
   	<div> 职称：<input type="text" name ="e_title"></input>  所属部门：<input type="text" name ="e_sector_name"></input> </div>
   	<div> 电子邮箱：<input type="text" name ="e_mail"></input>  职位编码：<input type="text" name="vocation_no"></div>
   	<div> 手机号码：<input type="text" name ="e_phone"></input>  家庭地址：<input type="text" name="e_address"></div>
   	<div> 身份证号码：<input type="text" name ="e_id"></input>  户口所在地：<input type="text" name="e_census"></div>
   	<div> 政治面貌：<input type="text" name ="e_status"></input>  社保卡号：<input type="text" name="e_social_cardid"></div>
   	<div> 学历：<input type="text" name ="e_education_background"></input>  毕业院校：<input type="text" name="e_grandual_college"></div>
   	<div> 专业：<input type="text" name ="e_specialty"></input>  薪酬标准：<input type="text" name="e_salary"></input></div>
   	<div> 银行账户：<input type="text" name ="e_account"></input>  开户银行：<input type="text" name="e_bank"></div>
   	<div> 登记人：<input type="text" name ="e_registiant"></input>  登记时间：<input type="text" name="e_register_date"></div>
   	<div> 家庭背景：<input type="text" name ="e_relation_background"></input>  个人履历：<input type="text" name="e_experience"></div>
   	<div> 备注：<input type="text" name ="e_remark"></input></div>
	   <input type="submit" value="提交">
   </form>
  </body>
</html>

