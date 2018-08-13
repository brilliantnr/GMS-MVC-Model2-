<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="contentBox">
	<div id="user-login-layout">
		<h1>사용자 로그인</h1>
		<form id="user-login-form" > 
			아이디		<br> <input id="user_id" type="text" name="user-id" /> <br/>
			비밀번호 	<br> <input id="user_password" type="text" name="user-password" /> <br/> <br/>
			<input id="login_form_btn" type="button" value="전송" /> 
		</form>
	</div>
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
</body>
</html>