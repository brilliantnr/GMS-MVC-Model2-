<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>비밀번호 변경</title>
</head>
<body>
	<h3>비밀번호 변경</h3>
	<!-- 아이디,old,new 비번 입력 (세션 아직 ) -->
	<form action="<%=ctx%>/member.do">
		아이디 입력			<br> <input type="text" name="update-check-id" /><br />
		기존 비밀번호 입력	<br> <input type="text" name="update-old-password" /><br />
		새로운 비밀번호 입력 	<br> <input type="text" name="update-new-password" /><br />
		<input type="submit" value="비밀번호 변경" /> 
		<input type="hidden" name="action" value="update" /> 
		<input type="hidden" name="page" value="update_result" />
	</form>
</body>
</html>


