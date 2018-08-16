<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="contentBox">
	<div id="join_div">
		<form id="join_form" name="joinForm">
		<h2>회원가입</h2>
			ID 			<br><input type="text" name="userid" /><br /> 
			이름 		<br><input type="text" name="name" /><br />
			생년월일	 	<br><input type="text" name="ssn" /><br /> 
			비밀번호	 	<br><input type="text" name="password" /><br /> 

			<br /> <br /> 
		<h4>소속팀</h4>
			<select name="teamid" id="teamid">
				<option value="A">놀자</option>
				<option value="H">지은집</option>
				<option value="S">터틀킹</option>
				<option value="C">코딩짱</option>
			</select>

		<h4>프로젝트 역할</h4><br /> 
			<select name="roll" id="roll">
				<option value="leader">팀장</option>
				<option value="front">프론트개발</option>
				<option value="back">백단개발</option>
				<option value="android">안드로이드개발</option>
				<option value="minfe">민폐</option>
			</select>
		<h4>수강과목</h4><br /> 
			<input type="checkbox" name="subject" value="java" checked="checked"/> Java
			<input type="checkbox" name="subject" value="clang" /> C언어
			<input type="checkbox" name="subject" value="JSP" /> JSP
			<input type="checkbox" name="subject" value="PHP" /> PHP
			<input type="checkbox" name="subject" value="nodejs" /> NodeJS
			<input type="checkbox" name="subject" value="linux" /> Linux
			<input type="checkbox" name="subject" value="html" /> HTML
			<input type="checkbox" name="subject" value="spring" /> Spring
			<br />
			<input id="join_form_btn" type="button" value="회원가입 " />  
			<br /> 
		</form>
	</div>
</div> <!-- content -->
	<script>
	

	document.getElementById('join_form_btn').addEventListener('click',function(){
		var form = document.getElementById('join_form');
		var x = service.nullChecker([ form.userid.value, form.name.value, form.ssn.value, form.password.value ]); //x에 json 담김
		if(x.checker){  //j.checker가 true 일때 실행됨.
			form.action = "${context}/member.do";  
			form.method = "post";
			member.join([ form.userid.value, form.name.value, form.ssn.value, form.password.value ]);
				
		//6단계)OOP loop (input hidden 삭제)
 		var arr = [
 			{'name':'action', 'value':'join'}, 
			{'name':'page', 'value':'mypage'},
			{'name':'gender', 'value': member.getGender()},
			{'name':'age','value': member.getAge()}
			];
			for(var i in arr){
				var node = document.createElement('input'); 
				node.setAttribute('type','hidden');
				node.setAttribute('name', arr[i].name);
				node.setAttribute('value', arr[i].value);
				form.appendChild(node);
			}
		
			form.submit();
		}else {			//j.checker가 false면 text('필수항목 입력바랍니다') 보여라
			alert(x.text);
		}
	});
	//document.form.user_id.value 으로 document 이용하려면 form에 name 부여해야함.
	
	</script>
