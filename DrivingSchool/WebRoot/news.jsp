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
		<script type="text/javascript" src="extjs4/ext-all.js"></script>
		<script type="text/javascript" src="script/news.js"></script>
		<link type="text/css" rel="stylesheet"
			href="extjs4/resources/css/ext-all.css" />
		<title>新闻管理</title>
	</head>

	<body>
	</body>
</html>
