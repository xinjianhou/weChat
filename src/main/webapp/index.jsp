<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>login</title>
	<script type="text/javascript" src="<%=path%>/resources/js/jquery.min.js"></script>
	<link type="text/css" href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" href="<%=path%>/resources/css/fontawesome-all.css" rel="stylesheet">
	<script type="text/javascript" src="<%=path%>/resources/js/bootstrap.min.js"></script>
    <link type="text/css" href="<%=path%>/resources/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/resources/js/layer.js"></script>
    <script type="text/javascript" src="<%=path%>/resources/js/jquery.md5.js"></script>
	
	<script type="text/javascript">
	function keyLogin(){    
        if (event.keyCode==13){
        		loginCheck();//调用登录按钮的登录事件    
         }
     }
	//登录前校验用户名和密码是否正确  
    function loginCheck(){  
        var name = $("#username").val();    //用户名  
        var pwd = $.md5($("#password").val());      //密码  
        var datas = new Object();                  //返回来的结果  
        $.ajax({    
            type: "get",    
//             contentType:"application/json",  
            dataType:"json",  
            async:false,  
            url : "${pageContext.request.contextPath}/before_check.do?username="+name+"&password="+pwd,   
            success: function (data) {
            	
                if(data.result == "nameFalse"){
                		//用户名不正确  
                    layer.tips('用户名不存在！', '#username', {
                      tips: [2, '#FF3030'],
                      time: 10000
                    });
                    $("#password").val("");
                    return false;  
                }else if(data.result == "pwdFalse"){
                		//密码不正确  
                    layer.tips('密码不正确   ！', '#password', {
                      tips: [2, '#FF3030'],
                      time: 10000
                    });
                    $("#password").val("");
                    return false;
                }else{
                		
                		$('#login_form').submit();
                 	return true; 
                    
                }  
            },
            error:function()
            {
                alert("服务器错误,请稍后再试。。。");
                return false;
            }
        });     
    }
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $.ajaxSetup({
        beforeSend: function (xhr) {
            if(header && token ){
                xhr.setRequestHeader(header, token);
            }
        }}
    );	
	</script>
	
</head>
<body onkeydown="keyLogin();">
	<div class="container">
		<div class="form row">
			<form class="form-horizontal col-md-offset-3" id="login_form" action="${pageContext.request.contextPath}/login" method="post">
				<h3 class="form-title">欢迎登陆</h3>
				<div class="col-md-9">
					<div class="form-group">
						<i class="fa fa-user fa-lg"></i> <input
							class="form-control required" type="text" placeholder="Username"
							id="username" name="username" value="${username}" autofocus="autofocus"
							maxlength="30" />
					</div>
					<div class="form-group">
						<i class="fa fa-lock fa-lg"></i> <input
							class="form-control required" type="password"
							placeholder="Password" id="password" name="password"
							maxlength="20" />
					</div>
					<div class="form-group">
						<label class="checkbox"> <input type="checkbox"
							name="remember-me"  />记住我
						</label>
					</div>
					<div class="form-group col-md-offset-9">
						<button type="button" id="sub_btn" class="btn btn-success pull-right"
							name="Submit" onClick="return loginCheck();">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>