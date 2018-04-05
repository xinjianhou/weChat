<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>WeChat-deny</title>
	<meta name="menu" content="home" />    
</head>
<body>
<h1 style="color:red">对不起，您没有权限访问该页面!</h1>
       
<div style="text-align:center">
	<img src="<%=path%>/resources/images/nonono.jpg"/>
	<p>
		<a href="<c:url value='/'/>">首页</a>
		<a href="<c:url value='/logout'/>" >退出登录</a>
	</p>
</div>
</body>
</html>