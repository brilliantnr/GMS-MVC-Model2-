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
<body><form action="<%=ctx%>/index.jsp"></form>
	<table class="tbl">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>팀명</td>
		<td>나이</td>
		<td>직책</td>
	</tr>
		<tr>
		
		</tr>
		
</table>
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="search_id_result" />
</body>
</html>

