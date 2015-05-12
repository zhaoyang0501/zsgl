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
			<h1 style="color: red;text-align: center;">注册成功,欢迎使用！</h1>
					
			</div>
		</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
	</div>

</body>
</html>