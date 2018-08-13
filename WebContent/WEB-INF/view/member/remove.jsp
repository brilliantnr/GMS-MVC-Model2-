<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
	<head>
<meta charset="UTF-8" />
<title>회원탈퇴</title>
	</head>
	<body>
		<div id="wrapper">
			<jsp:include page="../common/titleBox.jsp"/>
			<jsp:include page="../common/menuBox.jsp"/>
		<div id="content">
			<form id="delete_form" name="delete">
				비밀번호 확인<br><input type="password" name="pass" id="pass" /><br />
				<input id="delete_btn" type="button" value="회원탈퇴 요청" />
			</form>
		</div>
	</div>
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>
<script>

	document.getElementById('delete_btn').addEventListener('click', function() { //콜백펑션내 : 메소드
		var form = document.getElementById('delete_form'); // form 객체
		var pass = form.pass.value;
		if (pass === '${user.password}') {
			form.action = '${context}/member.do';
			form.method = 'post';

		//6단계) OOP개념(setter, getter 이용)
			var node = document.createElement('input');
			node.setAttribute('type', 'hidden');
			node.setAttribute('name', 'action');
			node.setAttribute('value', 'remove');
			form.appendChild(node);

			form.submit();
		} else {
			alert('비밀번호가 다릅니다.');
		}
	})

</script>
</body>
</html>