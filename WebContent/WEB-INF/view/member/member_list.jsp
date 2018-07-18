<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style>
	.tbl {border:1px solid black}
	.tbl tr{border:1px solid black}
	.tbl tr td{border:1px solid black}
	</style>
</head>
<body><form action="<%=ctx %>/member.do">
	<table class="tbl">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>팀명</td>
		<td>나이</td>
		<td>직책</td>
		
	</tr>
		
</table>
</form>
</body>
</html>

