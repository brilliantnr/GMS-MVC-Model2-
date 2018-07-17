<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<h3>회원 탈퇴 완료</h3>
	<form action="<%=ctx %>/index.jsp">
	<input type="submit" value="탈퇴완료" />
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="delete_result"/>
	</form>

	