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
		</form>
	</div>
	<script>
	
//5단계)JSON 사용(OOP)
	document.getElementById('login_form_btn').addEventListener('click',function(){
		var form = document.getElementById('user-login-form');
		var x = service.nullChecker([ form.user_id.value, form.user_password.value ]);  
		if(x.checker){
			form.action = "${context}/member.do";  
			form.method = "post";
			var node = document.createElement('input');  //<input type="hidden" name="action" value="login"/>	
				node.setAttribute('type','hidden');
				node.setAttribute('name','action');
				node.setAttribute('value','login');
				form.appendChild(node);
			form.submit();
		}else {
			alert(x.text);
		}
	});
	
	

	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script>
//======================================================================================================
/* 	
기본개념
	== : 자바에서의 값 비교
	=== : .equals()
 */
	
	
	/* 
(get 방식과 post 방식 비교)
	<form id="user-login-form" action="" method=""> 
	form.method = "get";
	get 방식일때 http://localhost:9000/GMS-MVC/member.do?user-id=01&user-password=123&action=login&page=mypage
	post 방식일때 http://localhost:9000/GMS-MVC/member.do
	*/
	
	
	/* document.getElementById('user-login-form').submit(); */
	
	/* 	
(validation 따로 만들기 전)
	var userid = form.user_id.value;
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
	
	
	/* 	document.getElementById('login_form_btn').addEventListener('click',function(){
		alert(' form태그 클릭 내부 !! ');
		var member = new Member();
		var form = document.getElementById('user-login-form');  //각 element의 id로 찾는다는 것
		form.action = "${context}/member.do";  
		form.method = "post";
		var userid = form.user_id.value;  //이름사이의 - 를 마이너스로 입력해서 사용불가.id 줘서 대용
		var password = form.user_password.value;
		alert('입력한 id '+userid);
		member.setUserid(userid);
		member.setPassword(password);
		if(service.loginvalidation(member)){  //리턴타입이 불린이니까 if문 써야함
			form.submit();
			}
	});
	 */
	
	 /* 
2단계)IIFE 패턴 중 배열(Array) 이용
	 document.getElementById('login_form_btn').addEventListener('click',function(){
		alert(' form태그 클릭 내부 !! ');
		var form = document.getElementById('user-login-form');  //각 element의 id로 찾는다는 것
		form.action = "${context}/member.do";  
		form.method = "post";
		if(service.nullChecker([form.user_id.value,form.user_password.value])){  //배열 하나로 보낸다
			form.submit();
			}
	});
	 */
	/* 
	 form 내에 hidden으로 설정해준 page를 감추기.
	 ## user_login_form.jsp
	 <input type="hidden" name="page" value="mypage" />
	 
	 ## LoginCommand.java
	 setPage("mypage");
	 */
	
	
	
	</script>
	
</body>
</html>


