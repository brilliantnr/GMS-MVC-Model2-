<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>사용자 로그인 화면</title>
<link rel="stylesheet" href="../../css/home/style.css" />
</head>
<body>
	<div id="user-login-layout" >
		<h1>사용자 로그인</h1>
		<form id="user-login-form" action="<%=ctx %>/member.do">
			아이디		<br> <input type="text" name="user-id" /> <br/>
			비밀번호 	<br> <input type="text" name="user-password" /> <br/> <br/>
			<input type="submit" value="전송" />
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="mypage" />
		</form>
	</div>
</body>
</html>


