<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>


	<h3>회원가입 성공</h3>
	<form action="<%=ctx %>/index.jsp">
	<input type="submit" value="성공" />
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="join_result" />
	</form>

