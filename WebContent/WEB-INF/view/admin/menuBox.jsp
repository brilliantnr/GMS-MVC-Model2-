<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a onclick="move('member','move','member_list')">LIST</a></li>
		<li><a onclick="move('member','move','search_id_form')">SEARCHID</a></li>
		<li><a href="${context}/index.jsp">ADMIN LOGOUT</a></li>
	</ul>
</div>


			<%-- <li><a href="${context}/member.do?action=move&page=member_list">LIST</a></li>
				<li><a href="${context}/member.do?action=move&page=search_id_form">SEARCH ID</a></li>
				<li><a href="${context}/index.jsp">ADMIN LOGOUT</a></li> --%>