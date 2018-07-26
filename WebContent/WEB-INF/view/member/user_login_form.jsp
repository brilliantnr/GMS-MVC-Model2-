<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>
	<div id="user-login-layout">
		<h1>사용자 로그인</h1>
		<form id="user-login-form" >
			아이디		<br> <input id="user_id" type="text" name="user-id" /> <br/>
			비밀번호 	<br> <input id="user_password" type="text" name="user-password" /> <br/> <br/>
			<input id="login_form_btn" type="button" value="전송" /> 
			<input type="hidden" name="action" value="login"/>
			<input type="hidden" name="page" value="mypage" />
		</form>
	</div>
	<script>
	document.getElementById('login_form_btn').addEventListener('click',function(){
		alert(' form태그 클릭 내부 !! ');
		var member = new Member();
		var form = document.getElementById('user-login-form');  //각 element의 id로 찾는다는 것
		form.action = "${context}/member.do";  
		form.method = "post";
		var userid = form.user_id.value;
		var password = form.user_password.value;
		alert('입력한 id '+userid);
		member.setUserid(userid);
		member.setPassword(password);
		if(service.loginvaliation(member)){
			form.submit();
			}
		//리턴타입이 불린이니까 if문 써야함
	});
	//이름사이의 - 를 마이너스로 입력해서 사용불가.
	//id 줘서 대용
	
/* 	var userid = form.user_id.value;
	var password = form.user_password.value;
	alert('입력한 id '+userid);
	var ok=false;
	if(this.userid===""){
		alert('ID을 입력하시오');
	}else if(this.user_password===""){
		alert('비밀번호를 입력하시오');
	}else{
		ok=true;
		form.submit();
	};
	return ok;  */

	//== : 자바에서의 값 비교
	//=== : .equals()
	
	/* document.getElementById('user-login-form').submit(); */
	
	/* <form id="user-login-form" action="" method=""> 
	//form.method = "get";
	//get 방식일때 http://localhost:9000/GMS-MVC/member.do?user-id=01&user-password=123&action=login&page=mypage
	//post 방식일때 http://localhost:9000/GMS-MVC/member.do
	*/
	
	</script>
</body>
</html>


