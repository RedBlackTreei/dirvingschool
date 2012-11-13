<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>帮助信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<ul>
		<li><p>人员管理：可对教练以及学员进行管理，课进行的操作有添加、删除、修改还有查询。</p></li>
		<li><p>学员管理：对学员进行添加、删除、修改还有查询。</p></li>
		<li><p>教练管理：对教练进行添加、删除、修改还有查询。</p></li>
		<li><p>车辆管理：类似上</p></li>
		<li><p></p></li>
		<li><p></p></li>
		<li><p></p></li>
		<li><p></p></li>
		<li><p></p></li>
		</ul>
		<br>
	</body>
</html>
