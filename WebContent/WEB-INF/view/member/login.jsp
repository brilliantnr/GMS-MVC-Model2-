<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="contentBox">
	<div id="login_layout">
		<h1>사용자 로그인</h1>
		<form id="login_form" > 
			아이디		<br> <input id="user_id" type="text" name="id" /> <br/>
			비밀번호 	<br> <input id="user_password" type="text" name="password" /> <br/> <br/>
			<input id="login_form_btn" type="button" value="전송" /> 
		</form>
	</div>
</div> <!-- content -->	
<script>


document.getElementById('login_form_btn').addEventListener('click',function(){
	var form = document.getElementById('login_form');
	var x = service.nullChecker([ form.user_id.value, form.user_password.value ]);  
	if(x.checker){
		form.action = "${context}/member.do";  
		form.method = "post";
		var node = document.createElement('input');  //<input type="hidden" name="action" value="login"/>	
			node.setAttribute('type','hidden');
			node.setAttribute('name','action');
			node.setAttribute('value','login');
			form.appendChild(node);
			
			var node1 = document.createElement('input');  //<input type="hidden" name="action" value="login"/>	
			node1.setAttribute('type','hidden');
			node1.setAttribute('name','page');
			node1.setAttribute('value','retrieve');
			form.appendChild(node1);
		form.submit();
	}else {
		alert(x.text);
	}
});



</script>