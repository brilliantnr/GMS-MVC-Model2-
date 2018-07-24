<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀이름 검색 페이지</title>
</head>
<body>
	<form action="${context}/member.do" onsubmit="return sendForm()" method="get">
		팀 이름 입력	<input type="text" name="search-team"/><br />
		<input type="submit" value="검색" />
		<input type="hidden" name="action" value="search"/>
		<input type="hidden" name="page" value="search_team_result" />
	</form>
	<script>
	function sendForm() {
		alert('--sendForm 통과--');
		return true;
	}
</script>
</body>
</html>