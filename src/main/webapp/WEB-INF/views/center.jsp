<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		
		var formvalidate= $("#regist_form").validate({
			errorPlacement: function(error, element) {
				$( element ).closest(".controls").append( error );
			},
			ignore:"",
			rules: {
				"user.userName":  "required",
				"user.password":  "required",
				"user.school":  "required",
				"user.className":  "required",
				"user.sex":  "required",
				"user.birthDay":  "required",
				},
			messages: {
				"user.userName":"请填写用户名",
				"user.password":"请填写密码",
				"user.school":"请填写学校",
				"user.className":"请填写班级",
				"user.sex":"请选择性别",
				"user.birthDay":"请选择生日"
				
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
		<div class="row" style="padding-top: 15px;">
			<div class="span12" >
			<h3>修改个人信息</h3>
					<form class="form-horizontal center" id='regist_form' method="post" action="${pageContext.request.contextPath}/docenter" style="border: 1px solid #E2E2E2;padding-top: 20px;">
					  <input type="hidden" value="${sessionScope.user.id}" name='user.id'>
					  <div class="control-group">
					    <label class="control-label" for="userName">用户名</label>
					    <div class="controls">
					      <input type="text" id="userName" value="${sessionScope.user.userName}" name="user.userName" placeholder=""  readonly="readonly" >
					    </div>
					  </div>
					  
					  <div class="control-group">
					    <label class="control-label" for="password">密码</label>
					    <div class="controls">
					      <input type="password" name="user.password" placeholder="" value="${sessionScope.user.password}">
					    </div>
					  </div>
					  
					   <div class="control-group">
					    <label class="control-label" for="user.school">学校</label>
					    <div class="controls">
					      <input type="text" name="user.school" placeholder="" value="${sessionScope.user.school}">
					    </div>
					  </div>
					  
					  <div class="control-group">
					    <label class="control-label" for="user.className">班级</label>
					    <div class="controls">
					      <input type="text"  name="user.className" value="${sessionScope.user.className}" >
					    </div>
					  </div>
					  
					    <div class="control-group">
					    <label class="control-label" for="inputPassword">性别</label>
					    <div class="controls">
					      <select name="user.sex">
					       <option value=""></option>
					       <c:if test="${sessionScope.user.sex=='男'}">
					       	<option selected="selected" value="男">男</option>
					       	  <option value="女">女</option>
					       </c:if>
					      <c:if test="${sessionScope.user.sex=='女'}">
					       	 <option  value="男">男</option>
					       	  <option selected="selected" value="女">女</option>
					       </c:if>
					    
					      </select>
					    </div>
					  </div>
					  
					   <div class="control-group">
					    <label class="control-label" for="user.birthDay">生日</label>
					    <div class="controls">
					      <div class=" input-append date">
										 <input name="user.birthDay"  type="text" value="<fmt:formatDate value="${user.birthDay}" type="time" dateStyle="full" pattern="yyyy-MM-dd"/>" readonly="readonly" >
										 <span class="add-on"><i class="icon-th"></i></span>
							</div>
					    </div>
					  </div>
					  
					  <div class="control-group">
					    <div class="controls">
					      <button type="submit" class="btn">保存信息</button>
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