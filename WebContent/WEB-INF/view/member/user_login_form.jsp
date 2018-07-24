<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>사용자 로그인 화면</title>
<link rel="stylesheet" href="${css}/style.css" />
</head>
<body>
	<div id="user-login-layout" >
		<h1>사용자 로그인</h1>
		<form id="user-login-form" action="${context}/member.do" onsubmit="return sendForm()" method="get">
			아이디		<br> <input type="text" name="user-id" /> <br/>
			비밀번호 	<br> <input type="text" name="user-password" /> <br/> <br/>
			<input type="submit" value="전송" />
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="mypage" />
		</form>
	</div>
		<script>
		function sendForm(){
			/*form 태그에서만 
			유효성 체크하는 곳 
			
			그리고 action 하라고 함.
			*/
			alert('123');
			return true;
		}
	</script>
</body>
</html>


