<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"
	isErrorPage="true"%>
<%@ include file="../common/taglibs.jsp"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<TITLE>访问错误--页面跳转中...</TITLE>
</head>
<body>
	<DIV id=container><IMG height=312 src="<%=path%>/resources/images/404.gif" width=512></DIV>
	<DIV id=maincolumn>
	  <DIV>请使用localhost:8081/WeChat访问本站</DIV>
	  <DIV><A href="http://localhost:8081/WeChat/" class="style1">ShunXin</A> - <A href="http://localhost:8081/WeChat/">授鱼予渔</A></DIV>
	</DIV>
	<DIV>Copyright © 2017 - 2018 <A href="http://localhost:8081/WeChat/">ShunXin</A>.Com All Rights Reserved.</DIV>
	</DIV>
</html>