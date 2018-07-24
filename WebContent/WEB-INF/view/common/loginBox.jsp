<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=application.getContextPath()%>" />
<div id="login-box">
	<a href="${ctx}/member.do?action=move&page=user_login_form">LOGIN </a>
	&nbsp;&nbsp;&nbsp;&nbsp; 
	<a href="${ctx}/member.do?action=move&page=join_form"> JOIN </a>
</div>