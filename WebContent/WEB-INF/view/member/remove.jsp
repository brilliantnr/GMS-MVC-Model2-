<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="contentBox">
	<form id="delete_form" name="delete">
		비밀번호 확인<br>
		<input type="password" name="pass" id="pass" /><br /> <input
			id="delete_btn" type="button" value="회원탈퇴 요청" />
	</form>
</div>
<!-- content End-->
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