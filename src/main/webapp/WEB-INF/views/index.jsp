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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ppts.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.22.min.js"></script>
</head>
<body>
	<%@ include file="top.jsp"%>
	<!----head end -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/u_header.js"></script>
	<div class="container">
		
		<div class="row">
			<div class="span12">
				<div class="bread-crumb">
					<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; <a href="#">首页</a>
				</div>
			</div>
		</div>

		<div class="row" style="padding-top: 15px;">
			
			<div class="span12">
				<div class="block-wrapper random random-0">
				<div class="ppt-list-header">
					<h2>最新上传</h2>
					<a class="float-right more" href="find">更多&nbsp;&gt;</a>
					<div class="bottom-line"></div>
				</div>
				
				<ul class="ppt-list">
					<c:forEach items="${resourcesNew }" var="bean">
					<li>
							<div>
								<div class="ppt-cover-content">
									<a href="detail?id=${bean.id }">
										<img width="180" height="135" src="upload/${bean.imgPath }">
									</a>
								</div>
								<p class="subject">
									<a href="detail?id=${bean.id }">${bean.name }</a>
								</p>
								<div class="ppt-visit-count">
									<div class="float-left">
										<span>${bean.count } 浏览</span>
									</div>
									<div class="float-right">
										<span>${bean.createDate } </span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			<div class="block-wrapper random random-1">
				<div class="ppt-list-header">
					<h2>浏览最多</h2>
					<a class="float-right more" href="find">更多&nbsp;&gt;</a>
					<div class="bottom-line"></div>
				</div>
				
				<ul class="ppt-list">
					<c:forEach items="${resourcesHot }" var="bean">
					<li>
							<div>
								<div class="ppt-cover-content">
									<a href="detail?id=${bean.id }">
										<img width="180" height="135" src="upload/${bean.imgPath }">
									</a>
								</div>
								<p class="subject">
									<a href="detail?id=${bean.id }">${bean.name }</a>
								</p>
								<div class="ppt-visit-count">
									<div class="float-left">
										<span>${bean.count } 浏览</span>
									</div>
									<div class="float-right">
										<span>${bean.createDate } </span>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
	</div>

</body>
</html>