<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=7, IE=8">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-custom.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui-custom.min.css">
<link rel="stylesheet" type="text/css"href="${pageContext.request.contextPath}/css/core.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.22.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<link href="${pageContext.request.contextPath}/css/datetimepicker.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function(){
		$(".date").datetimepicker({
			language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
	        format:'yyyy-mm-dd',
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
	});
</script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<!----head end -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/u_header.js"></script>
	<div class="container">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ppts.css">
		<div class="row" style="padding-top: 15px;">
			
			<div class="span12" >
			<h3 style="color: red;text-align: center;" >${tip }</h3>
			<div class="container-fluid" style="margin-left: auto;margin-right: auto;width: 300px; border: 1px solid #E2E2E2;">  
			    <form accept-charset="UTF-8" action="./dologin" class="form-horizontal" method="post">
			    <fieldset class="login">
			        <legend class="form_legend">登录</legend>
			        <div class="mobile-index-login" style="padding-top: 20px;">
			            <div class="control-group">
			                <input name="user.userName" type="text" placeholder="用户名" class="login_text_input">
			            </div>
			            <div class="control-group">
			                <input name="user.password" type="password" placeholder="密码" class="login_text_input">
			            </div>
			            <div class="control-group">
			                <button type="submit" class="btn btn-primary">
			                    &nbsp;登&nbsp;录&nbsp;
			                </button>
			                &nbsp;
			                <a href="./register" class="btn">&nbsp;注&nbsp;册&nbsp;</a>
			            </div>
			        </div>
			    </fieldset>
			</form>
		</div>


  </div>
		</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
	</div>

</body>
</html>