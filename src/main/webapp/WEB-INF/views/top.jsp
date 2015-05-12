<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="index-topbar-wrapper">
		<div class="light-blue-left"></div>
		<div class="index-topbar clearfix">
			<div class="topbar-light">
				<img alt="腾讯大讲堂 给成长加点料" src="${pageContext.request.contextPath}/images/topbar-light.jpg">
			</div>
			<div class="topbar-logo">
			</div>
			
			<c:if test="${sessionScope.user!=null}">  
			   <div class="login-container" id="login_container">
				<div class="user-name-wrapper">
					<div class="user-name-inner">
						<span class="user-name"><strong class="vwmy qq">${user.userName }</strong>&nbsp;</span>
						<span class="sf-sub-indicator"> ?</span>
					</div>
					<ul class="user-name-dropdown" style="width: 82px;">
						<li><a href="center">个人中心</a></li>
						<li><a href="./loginout">退出</a></li>
					</ul>
				</div>
			</div> 
			</c:if> 
			<c:if test="${sessionScope.user==null}"> 
				<div class="login-container" id="login_container">
				<span><a href="./login">登录</a></span>
				| <span><a href="./register" > 注册 </a></span>
				</div>
			</c:if>
			<ul class="topbar-nav-list sf-menu" id="djt_menu">
				<li id="nav_1"><a href="${pageContext.request.contextPath}/index">首页</a></li>
				<li id="nav_3"><a href="${pageContext.request.contextPath}/find">无损知识检索</a></li>
				<li id="nav_6"><a href="${pageContext.request.contextPath}/myupload">我的上传</a></li>
				<li id="nav_6"><a href="${pageContext.request.contextPath}/center">个人中心</a></li>
			</ul>
		</div>
	</div>