<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!-- "oracle.jdbc.driver.OracleDriver" --> 
	<!-- "jdbc:oracle:thin:@localhost:1521:xe"  -->
	<!-- "rachel"  -->
	<!-- "7003"  -->
<% 
	String ctx = application.getContextPath();
%>
	
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> 사용자 로그인 RESULT </title>
</head>
<body>
	<form action="<%=ctx %>/index.jsp">
	<input type="submit" value="로그인 성공" />
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="user_login_result" />	
	</form>
</body>
</html>

