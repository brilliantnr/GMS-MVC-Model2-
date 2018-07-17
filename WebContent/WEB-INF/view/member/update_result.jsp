<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<h3>회원정보 수정 결과</h3>
	<form action="<%=ctx %>/index.jsp">
	<input type="submit" value="수정완료" />
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="update_result" />
	</form>

	