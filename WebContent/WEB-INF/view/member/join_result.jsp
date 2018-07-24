<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<h3>회원가입 성공</h3>
	<form action="${context}/index.jsp" onsubmit="return sendForm()" method="get">
	<input type="submit" value="성공" />
	<input type="hidden" name="action" value="move"/>
	<input type="hidden" name="page" value="join_result" />
	</form>
<script>
	function sendForm() {
		alert('--sendForm 통과--');
		return true;
	}
</script>
