<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
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
<link href="http://djt.qq.com/djt/css/article/article.css?v=v21375" rel="stylesheet">
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
<style type="text/css">
.event-apply-wrapper .btn {
  width: 150px;
  line-height: 40px;
  padding: 0;
  font-size: 16px;
  margin: 0 auto;
  background-image: none;
  background-color: #009CFF;
  color: #FFF;
}
</style>
</head>
<body>
	<%@ include file="top.jsp"%>
	<!----head end -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/u_header.js"></script>
	<div class="container">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ppts.css">
		<div class="row" style="padding-top: 15px;">
			<div class="span8">
				<ul class="article-list">
				
				<c:if test="${fn:length(resources)==0}">
					<p>目前还没有上传资源</p>
				</c:if>
				<c:forEach items="${resources}" var="bean">
					<li class="article-list-item "> 
						<div class="item-cover">
							<a href="detail?id=${bean.id }"><img width="106px;" alt="${bean.name }" src="${pageContext.request.contextPath}/upload/${bean.imgPath}"></a>
						</div>
						<div class="item-detail">
							<h1><a href="detail?id=${bean.id }">${bean.name }</a> 
							<div class="btn-group pull-right">
				                <button class="btn dropdown-toggle" data-toggle="dropdown">操作 <span class="caret"></span></button>
				                <ul class="dropdown-menu">
				                  <li><a href="${pageContext.request.contextPath}/goupload?resource.id=${bean.id }">编辑</a></li>
				                  <li><a href="${pageContext.request.contextPath}/deleteResource?resource.id=${bean.id }">删除</a></li>
				                </ul>
				              </div>
							 </h1>
							<p class="item-author">${bean.creater.userName} &nbsp;${bean.createDate }</p>
							<p class="item-summary">${bean.remark }</p>
							<div class="item-control">
								<div class="item-oper-info">
									<span><i class="icon-reading"></i>&nbsp;${bean.count }浏览&nbsp;&nbsp;</span> 
								</div>
							</div>
						</div>
					</li>
				</c:forEach>
		</ul>
	</div><!-- left end span12 -->
	<div class='span4'>
	<div class="event-apply-wrapper left" style="  padding: 20px 15px;background: #f0f0f0;text-align: center;height: 100%" >
			<p>上传你的资源文件吧</p>
			<a href="./goupload" class="btn btn-success event-apply" data-toggle="modal" >上   传</a>
		</div>
	
	
	</div>
</div>
</div>
</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
</div>

</body>
</html>