<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登录页面</title>
	</head>
	<body>
		<s:form action="loginAction" method="post">
			<s:textfield label="用户名" name="person.username" />
			<br />
			<s:password label="密码" name="person.password" />
			<br />
			<s:select name="type" list="{'学员','教练','管理员'}" headerKey="-1"
				headerValue="--请选择角色--" label="角色" />
			<s:submit value="submit" />
			<s:reset value="reset" />
		</s:form>
	</body>
</html>