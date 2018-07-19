<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름 검색 페이지</title>
</head>
<body>
	<form action="<%=ctx %>/member.do">
		팀 이름 입력	<input type="text" name="search-team"/><br />
		<input type="submit" value="검색" />
		<input type="hidden" name="action" value="search"/>
		<input type="hidden" name="page" value="search_team_result" />
	</form>
</body>
</html>