<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
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



<form id="editForm" action="admin/updateDoc">
	<input type="hidden"  name="id" value="${oneCompleteDoc.id}"/>
	<input type="hidden" name="doc_check_status" value="${oneCompleteDoc.doc_check_status}">
	<div> 姓名：<input type="text"  name ="e_name" value="${oneCompleteDoc.e_name}"></input>  性别：<input type="text" value="${oneCompleteDoc.e_sex}" name="e_sex"></input></div>
	<div> 职位名称：<input type="text" value="${oneCompleteDoc.e_position}" readonly="readonly" name ="e_position"></input>  文档编码：<input type="text" value="${oneCompleteDoc.doc_no}" name="doc_no"></div>
	<div> 档案状态：<input type="text" value="${oneCompleteDoc.doc_status}" readonly="readonly" name="doc_status"></input></div>
	<div> 职称：<input type="text" value="${oneCompleteDoc.e_title}" name ="e_title"></input>  所属部门：<input type="text" value="${oneCompleteDoc.e_sector_name}" name ="e_sector_name"></input> </div>
	<div> 电子邮箱：<input type="text" value="${oneCompleteDoc.e_mail}" name ="e_mail"></input>  职位编码：<input type="text" value="${oneCompleteDoc.vocation_no}" name="vocation_no"></div>
	<div> 手机号码：<input type="text" value="${oneCompleteDoc.e_phone}" name ="e_phone"></input>  家庭地址：<input type="text" value="${oneCompleteDoc.e_address}" name="e_address"></div>
	<div> 身份证号码：<input type="text" value="${oneCompleteDoc.e_id}" name ="e_id"></input>  户口所在地：<input type="text" value="${oneCompleteDoc.e_census}" name="e_census"></div>
	<div> 政治面貌：<input type="text" value="${oneCompleteDoc.e_status}" name ="e_status"></input>  社保卡号：<input type="text" value="${oneCompleteDoc.e_social_cardid}" name="e_social_cardid"></div>
	<div> 学历：<input type="text" value="${oneCompleteDoc.e_education_background}" name ="e_education_background"></input>  毕业院校：<input type="text" value="${oneCompleteDoc.e_gradual_college}" name="e_grandual_college"></div>
	<div> 专业：<input type="text" value="${oneCompleteDoc.e_specialty}" name ="e_specialty"></input>  薪酬标准：<input type="text" value="${oneCompleteDoc.e_salary}" name="e_salary"></input></div>
	<div> 银行账户：<input type="text" value="${oneCompleteDoc.e_account}" name ="e_account"></input>  开户银行：<input type="text" value="${oneCompleteDoc.e_bank}" name="e_bank"></div>
	<div> 登记人：<input type="text" value="${oneCompleteDoc.e_registrant}" name ="e_registrant"></input>  登记时间：<input type="text" value="${oneCompleteDoc.e_register_date}" name="e_register_date"></div>
	<div> 家庭背景：<input type="text" value="${oneCompleteDoc.e_relation_background}" name ="e_relation_background"></input>  个人履历：<input type="text" value="${oneCompleteDoc.e_experience}" name="e_experience"></div>
	<div> 备注：<input type="text" value="${oneCompleteDoc.e_remark}" name ="e_remark"></input></div>
	<input type="submit" value="提交">
</form>


</body>
</html>

