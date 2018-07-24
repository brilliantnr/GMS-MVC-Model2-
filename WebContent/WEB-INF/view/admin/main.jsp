<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<c:set var="ctx" value="<%=application.getContextPath() %>"/>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>관리자 페이지 입니당 ★</title>
<link rel="stylesheet" href="${ctx}/resources/css/home/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<jsp:include page="../common/titleBox.jsp" />
			<jsp:include page="menuBox.jsp" />
		</div>
		<!-- header end -->
		<div id="content">
			<jsp:include page="contentBox.jsp" />
		</div>
		<!-- content end -->
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp" />
		</div>
	</div>