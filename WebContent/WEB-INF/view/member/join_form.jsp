<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../common/head.jsp"/>
<title>회원가입화면</title>
</head>
<body>
	<div id="join-form">
		<form id="join_form_form" name="joinForm">
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
			<option value="leader">	팀장			</option>
			<option value="front">	프론트개발	</option>
			<option value="back">	백단개발		</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">	민폐			</option>
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
	
		<br /> <br />
			<input type="hidden" name="action" value="join" /> 
			<input type="hidden" name="page" value="mypage" /> 
			<input id="join_form_btn" type="button" value="회원가입 " />  
			 <br /> <br /> 
		</form>
	</div>
	<script>
//5단계)JSON 사용(OOP)
	document.getElementById('join_form_btn').addEventListener('click',function(){
		var form = document.getElementById('join_form_form');
		var x = service.nullChecker([ form.userid.value, form.name.value, form.ssn.value, form.password.value ]); //x에 json 담김
		if(x.checker){  //j.checker가 true 일때 실행됨.
			form.action = "${context}/member.do";  
			form.method = "post";
			member.join([ form.userid.value, form.name.value, form.ssn.value, form.password.value ]);
				
		//6단계)OOP loop
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script>
	/* <!-- <br><input type="radio" name="teamid" value="none" checked="checked" />	없음
		<br><input type="radio" name="teamid" value="A" />	강놀자
		<br><input type="radio" name="teamid" value="H" />	지은이네 
		<br><input type="radio" name="teamid" value="S" />	왕거북이 
		<br><input type="radio" name="teamid" value="C" />	코딩짱  --> */
	
/*  배열로 담기 전 상태)
document.getElementById('join_form_btn').addEventListener('click',function(){
		alert('조인 폼 태그 클릭 내부!!');
		var member = new Member();
		var form = document.getElementById('join_form_form');
		form.action ="${context}/member.do";  // 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다.
		form.method="post";
		var userid = form.user_id.value;
		var name = form.name.value;
		var ssn = form.ssn.value;
		var password = form.password.value;
		member.setUserid(userid);
		member.setName(name);
		member.setPassword(password);
		member.setSsn(ssn);
		if(service.joinvaliation(member)){
			form.submit();
		}
	}); 
	*/
	
	/* 	document.getElementById('join_form_btn').addEventListener('click',function(){
	alert('조인 폼 태그 클릭 내부!!');
	var form = document.getElementById('join_form_form');
	form.action ="${context}/member.do";  // 이렇게하면 action은 어트리뷰트->프로퍼티로 바뀌고 값을 바꿀수있게된다.
	form.method="post";
	if(service.joinvaliation([form.user_id.value,form.name.value,form.ssn.value,form.password.value])){
		form.submit();
	}
});
 */
 
 /* 
 6단계) 정적 코딩제거하기
 방법1) JSP의 <script>에서 function()내에서 작업
 before)
<input type="hidden" name="action" value="join" /> 
<input type="hidden" name="page" value="mypage" /> 
	form.gender.value = member.getGender();
	form.age.value= member.getAge();
	
	//6단계)OOP loop
		var arr = [{'name':'action', 'value':'join'}, 
			{'name':'page', 'value':'mypage'},
			{'name':'gender', 'value': member.getGender()},
			{'name':'age','value': member.getAge()}];
			for(var i in arr){
				var node = document.createElement('input'); 
				node.setAttribute('type','hidden');
				node.setAttribute('name', arr[i].name);
				node.setAttribute('value', arr[i].value);
				alert(arr[i].name);
				form.appendChild(node);
			}	
	
 
 
 */
 
 
 
 
	
	
	
</script>
</body>
</html>
