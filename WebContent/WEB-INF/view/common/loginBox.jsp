<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="login-box">
	<a id="move_login_form" >LOGIN </a>
	&nbsp;&nbsp;&nbsp;&nbsp; 
	<a onclick="common.move('member','move','join_form')">JOIN </a>
</div>
<script>
//a태그에 이벤트(onclick)를 걸어서 이동하는 것은 객체지향에 어긋난다.
	
	document.getElementById('move_login_form').addEventListener('click',function(){
		//콜백함수
		alert('클릭 이벤트 체크!!');
		common.move('member','move','user_login_form');
	});
	

/* 	var move_login_form = document.getElementById('move_login_form');
	move_login_form.addEventListener('click',function());
	alert('클릭 이벤트 체크!!'); */
	
</script>