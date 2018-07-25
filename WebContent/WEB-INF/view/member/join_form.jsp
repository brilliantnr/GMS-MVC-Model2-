<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
userid, name, birth(800101-1),  password
roll, teamId,; 
-->
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../common/head.jsp"/>
<title>회원가입화면</title>
</head>
<body>
	<div id="join-form">
		<form id="join_form_form">
			<h2>회원가입</h2>
			ID 			<br><input type="text" name="new-user-id" /><br /> 
			이름 		<br><input type="text" name="new-user-name" /><br />
			생년월일	 	<br><input type="text" name="new-user-birth" /><br /> 
			비밀번호	 	<br><input type="text" name="new-user-password" /><br /> 
			<input type="hidden" name="action" value="join" /> 
			<input type="hidden" name="page" value="join_result" /> 
			<input id="join_form_btn" type="submit" value="회원가입 " />
		</form>
	</div>
	<script>
	function sendForm() {
		alert('--sendForm 통과--');
		return true;
	}
	
	member.setUserid('유효성 체크 id ');
	alert('유효성체크값:' +member.loginvaliation());
	document.getElementById('join_form_btn').addEventListener('click',function(){
		alert('조인 폼 태그 클릭 내부!!');
		var form = document.getElementById('join_form_form');
		form.action ="${context}/member.do";
		form.method="post";
		
		
	})
</script>
</body>
</html>









