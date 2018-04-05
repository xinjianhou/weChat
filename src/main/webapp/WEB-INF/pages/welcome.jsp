<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
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
		width: 240px;
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
		left: 246px;
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
	$(".nav li").click(function() {
		$(".active").removeClass('active');
		$(this).addClass("active");
	});
</script>  
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" >WeChat</a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
               <li role="presentation">
                   <a>当前用户：<span class="badge">${user.userName}</span></a>
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
     <div class="pageSidebar">
         <ul class="nav nav-stacked nav-pills">
             <li role="presentation">
                 <a href="nav1.html" target="mainFrame" >导航链接1</a>
             </li>
             <li role="presentation">
                 <a href="nav2.html" target="mainFrame">导航链接2</a>
             </li>
             <li role="presentation">
                 <a href="nav3.html" target="mainFrame">导航链接3</a>
             </li>
             <li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                     导航链接4<span class="caret"></span>
                 </a>
                 <ul class="dropdown-menu">
                     <li>
                         <a href="nav1.html" target="mainFrame">导航链接4-1</a>
                     </li>
                     <li>
                         <a href="nav2.html" target="mainFrame">导航链接4-2</a>
                     </li>
                     <li>
                         <a href="nav3.html" target="mainFrame">导航链接4-3</a>
                     </li>
                 </ul>
             </li>
             <li role="presentation">
                 <a href="nav4.html" target="mainFrame">导航链接5</a>
             </li>
         </ul>
     </div>
     <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
		<form action="<%=basePath %>/logout" id="mainForm" method="POST">
			<h1>
				hello!
			</h1>
		</form>
     </div>
 </div>
 <!-- 底部页脚部分 -->
 <div class="footer">
     <p class="text-center">
         2017 &copy; Com.ShunXin
     </p>
 </div>


	
</body>
</html>