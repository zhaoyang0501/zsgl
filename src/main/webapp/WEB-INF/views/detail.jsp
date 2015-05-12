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
</head>
<body>
	<%@ include file="top.jsp"%>
	<!----head end -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/u_header.js"></script>
	<div class="container">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ppts.css">
		<div class="row">
			<div class="span12">
				<div class="bread-crumb">
					<a href="#">首页</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp; <a href="#">资源检索</a>
				</div>
			</div>
		</div>
		<div class="row" style="padding-top: 15px;">
		<div class="span8">
			<div class="row">
				<div class="span12">
					<div class="ppt-title">
						<h1>(${resource.category.name })${resource.name} </h1>
					</div>
					<div class="ppt-title-info">
						<div class="info-item ppt-created-time">
							发布时间 : ${resource.createDate}
							发布人 : ${resource.creater.userName}
							浏览次数 : ${resource.count}
						</div>
					</div>
				</div>
			</div>
			<p>${resource.remark }</p>
		<c:if test="${isVideo}">
			<div class="ppt">
				<div id="flash_content">	
					<div id="flash_div">
					<video src="./upload/${resource.filePath }" width="100%" height="100%" controls="controls">您的浏览器不支持此种视频格式。</video> 
					</div>
				</div>		
			</div>
		</c:if>
		
		<div class="ppt-detail">
			<div class="bshare" id="bshre_element">
			</div>
			<div class="ppt-download">
				<a class="download-btn"  href="./upload/${resource.filePath }"">立即下载</a>
			</div>
		</div>
	</div>
		<div class="span4">
			
		<div class="relative-res relative-ppts">
			<h2>相关资源</h2>
			<div class="items">
				<ul class="relative-ppt-wrapper higher">
					<c:forEach items="${resources }" var="bean">
						<li class="item" rel="1">
							<a class="item-img-wrapper" title="${bean.name }  " href="detail?id=${bean.id }">
								<img alt="${bean.name } " src="upload/${bean.imgPath }">
							</a>
							<div class="item-detail">
								<p class="item-name"><a href="detail?id=${bean.id }">${bean.name }  </a></p>
								<p class="download-count light-grey">${bean.count } 浏览</p>
							</div>
						 </li>
					</c:forEach>
				</ul>
			</div>
			</div>
		
				
	</div>	
		</div>
		<!-- 页脚 -->
		<%@ include file="foot.jsp"%>
	</div>

</body>
</html>