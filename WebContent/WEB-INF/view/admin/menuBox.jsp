<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=application.getContextPath()%>" />
<div id="menu-box">
			<ul id="menu">
				<li><a href="${ctx}/member.do?action=move&page=member_list">LIST</a></li>
				<li><a href="${ctx}/member.do?action=move&page=search_id_form">SEARCH ID</a></li>
				<li><a href="${ctx}/index.jsp">ADMIN LOGOUT</a></li>
			</ul>
		</div>