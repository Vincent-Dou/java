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
   <form>
   	<div> 姓名：<input type="text" name ="e_name"></input>  性别：<select name="e_sex"><option value="place">--请选择</option><option value="female">女</option><option value="male">男</option></select></div>
   	<div> 职位名称：<select name ="e_position"><option value="plase">--请选择</option><option value="departer">部门经理</option><option value="departer">部门经理</option></select>  文档编码：<input type="text" name="doc_no"></div>
   	<div> 档案状态：<select name="doc_status"><option value="plase">--请选择</option><option value="trial">试用期</option><option value="officer">正式员工</option><option value="dimission">离职</option><option value="delect">已删除</option></select></div>
   	<div> 职称：<input type="text" name ="e_title"></input>  所属部门：<input type="text" name ="e_sector_name"></input> </div>
   	<div> 电子邮箱：<input type="text" name ="e_mail"></input>  职位编码：<input type="text" name="vocation_no"></div>
   	<div> 手机号码：<input type="text" name ="e_phone"></input>  家庭地址：<input type="text" name="e-address"></div>
   	<div> 身份证号码：<input type="text" name ="e_id"></input>  户口所在地：<input type="text" name="e_census"></div>
   	<div> 政治面貌：<input type="text" name ="e_status"></input>  社保卡号：<input type="text" name="e_social_cardid"></div>
   	<div> 学历：<select name ="e_education_background"><option value="plase">--请选择</option><option value="junior">专科</option><option value="bachelor">本科</option><option value="master">硕士</option><option value="doctor">博士</option></select>  毕业院校：<input type="text" name="e_grandual_college"></div>
   	<div> 专业：<input type="text" name ="e_specialty"></input>  薪酬标准：<select name="salary"><option value="plase">--请选择</option><option value="primary">初级软件工程师</option><option value="middle">中级软件工程师</option><option value="heigh">高级软件工程师</option></select></div>
   	<div> 银行账户：<input type="text" name ="e_account"></input>  开户银行：<input type="text" name="e_bank"></div>
   	<div> 登记人：<input type="text" name ="e_registiant"></input>  登记时间：<input type="text" name="e_register_date"></div>
   	<div> 家庭背景：<input type="text" name ="e_relation_background"></input>  个人履历：<input type="text" name="e_experience"></div>
   	<div> 备注：<input type="text" name ="e_remark"></input></div>
   	<div><a href="#"><input type="button" name="e_accessory_path" value="附件"></a><input type="submit" name="submit" value="保存" checked="checked"><a href="index.jsp"><input type="button" name="return" value="返回"></a></div>
   </form>
  </body>
</html>
