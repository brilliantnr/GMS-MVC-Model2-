<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>아이디 검색 페이지</title>
</head>
<body>
	<form action="<%=ctx %>/member.do">
		이름 입력	<input type="text" name="search-id-name"/><br />
		생년월일 입력 <input type="text" name="search-id-birth" />
		<input type="submit" value="ID 검색" />
		<input type="hidden" name="action" value="retrieve"/>
		<input type="hidden" name="page" value="search_id_result" />
	</form>
</body>
</html>