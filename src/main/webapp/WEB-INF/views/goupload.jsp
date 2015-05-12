<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
	<%@ include file="validateLogin.jsp"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
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
		var formvalidate= $("#resource_form").validate({
			errorPlacement: function(error, element) {
				$( element ).closest(".controls").append( error );
			},
			ignore:"",
			rules: {
				"resource.name":  "required",
				"categoryId":  "required",
				"imgPath":  "required",
				"filePath":  "required"
				},
			messages: {
				"resource.name":  "请填写资源名称",
				"categoryId":  "请选择资源类别",
				"imgPath":  "请上传缩略图图片",
				"filePath":  "请上传资源文件"
				
			}
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
			<h3> ${ resource.id ==null?"上传资源":"修改资源"}</h3>
					<form id='resource_form' class="form-horizontal center" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/doUpload" style="border: 1px solid #E2E2E2;padding-top: 20px;">
					  <input type="hidden" name='resource.id' value="${resource.id }">
					  <div class="control-group">
					    <label class="control-label" for="userName">资源名称</label>
					    <div class="controls">
					      <input type="text"  name="resource.name" placeholder="" value='${resource.name}'/>
					    </div>
					  </div>
					   <div class="control-group">
					    <label class="control-label" for="userName">类别</label>
					    <div class="controls">
					     	<select name='categoryId' value="${resource.category.id }">
					     	<option value=""></option>
					     		<c:forEach items="${categorys }" var="bean">
					     		<c:if test="${resource.category.id==bean.id}">
					     			<option selected="selected" value="${bean.id }">${bean.name }</option>
					     		</c:if>
					     		<c:if test="${resource.category.id!=bean.id}">
					     			<option value="${bean.id }">${bean.name }</option>
					     		</c:if>
					     		</c:forEach>
					     	</select>
					    </div>
					  </div>
					  
					 
					  <div class="control-group">
					    <label class="control-label" for="password">缩略图</label>
					    <div class="controls">
					      <input name='imgPath' type="file" class="file" >
					    </div>
					  </div>
					   <div class="control-group">
					    <label class="control-label" for="user.school">选择文件</label>
					    <div class="controls">
					      <input name='filePath' type="file" class="file">
					    </div>
					  </div>
					  
					   <div class="control-group">
					    <label class="control-label" for="password">描述</label>
					    <div class="controls">
					      <textarea rows="3" cols="" name='resource.remark'>${resource.remark }</textarea>
					    </div>
					  </div>
					  
					  <div class="control-group">
					    <div class="controls">
					      <button type="submit" class="btn">提交</button>
					    </div>
					  </div>
				</form>
			</div>
		</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
	</div>

</body>
</html>