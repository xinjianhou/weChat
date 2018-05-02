<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<base href="<%=basePath%>">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.min.js"></script>
	<link type="text/css" href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="<%=path%>/resources/css/fontawesome-all.css" rel="stylesheet">
	<script type="text/javascript" src="<%=path%>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/layer.js"></script>
	<link type="text/css" href="<%=path%>/resources/css/bootstrap-table.css" rel="stylesheet">
	<script type="text/javascript" src="<%=path%>/resources/js/bootstrap-table.js"></script> 
	<title>Home Page</title>
	<style type="text/css">
	body {
		width: 100%;
		height: 100%;
		margin: 0;
		overflow: hidden;
		background-color: #FFFFFF;
		font-family: "Microsoft YaHei", sans-serif;
	}
	
	.pageSidebar {
		width: 180px;
		height: 100%;
		padding-bottom: 30px;
		overflow: auto;
		background-color: #e3e3e3;
	}
	
	.splitter {
		width: 5px;
		height: 100%;
		bottom: 0;
		left: 240px;
		position: absolute;
		overflow: hidden;
		background-color: #fff;
	}
	
	.pageContent {
		height: 100%;
		min-width: 768px;
		left: 188px;
		top: 0;
		right: 0;
		z-index: 3;
		padding-bottom: 30px;
		position: absolute;
	}
	
	.pageContainer {
		bottom: 0;
		left: 0;
		right: 0;
		top: 53px;
		overflow: auto;
		position: absolute;
		width: 100%;
	}
	
	.footer {
		width: 100%;
		height: 30px;
		line-height: 30px;
		margin-top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		position: absolute;
		z-index: 10;
		background-color: #DFDFDF;
	}
	</style>
<script type="text/javascript">
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$.ajaxSetup({
		beforeSend : function(xhr) {
			if (header && token) {
				xhr.setRequestHeader(header, token);
			}
		}
	});
	
	function goPage(url){
		window.location.href="${pageContext.request.contextPath}/"+url;
	}
	
</script>  
<sitemesh:write property='head'/>
</head>
<body>
<form action="<%=basePath %>/logout" id="mainForm" method="POST">
<nav class="navbar navbar-inverse navbar-fixed-left navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" >WeChat</a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
               <li role="presentation">
                   <a>当前用户：<span class="badge">${user.realName}</span></a>
               </li>
               <li>
                   <a href="#" onclick="document.getElementById('mainForm').submit();return false">
                         <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
       </div>
    </div>      
</nav>
</nav>
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar navbar-fixed-left navbar-fixed-top" style="margin-top:52px;">
         <ul class="nav nav-stacked nav-pills text-center">
             <li role="presentation" id="welcome">
                 <a href="" data-toggle="tab" onclick="goPage('welcome')">首页</a>
             </li>
             <li role="presentation" id="message">
                 <a href="" data-toggle="tab" onclick="goPage('message')">消息维护</a>
             </li>
             <li role="presentation" id="sth">
                 <a href="" data-toggle="tab">导航链接3</a>
             </li>
             <li role="presentation">
                 <a data-toggle="tab" href="">
                     导航链接4</span>
                 </a>
             </li>
             <li role="presentation">
                 <a href="nav4.html" data-toggle="tab">导航链接5</a>
             </li>
         </ul>
     </div>
     <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
		 <sitemesh:write property='body'/>
     </div>
 </div>
 


</form>	
<script type="text/javascript">

	$('#${id}').addClass('active');
</script>
</body>

</html>