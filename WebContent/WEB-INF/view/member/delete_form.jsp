<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
	<head>
<meta charset="UTF-8" />
<title>회원탈퇴</title>
	</head>
	<body>
		<div id="wrapper">
			<jsp:include page="../common/titleBox.jsp"/>
			<jsp:include page="../common/menuBox.jsp"/>
		<div id="content">
			<form id="delete_form" name="delete">
				비밀번호 확인<br><input type="password" name="pass" id="pass" /><br />
				<input id="delete_btn" type="button" value="회원탈퇴 요청" />
			</form>
		</div>
	</div>
		<div id="footer">
			<jsp:include page="../common/footerBox.jsp"/>
		</div>
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
			node.setAttribute('value', 'delete');
			form.appendChild(node);

			form.submit();
		} else {
			alert('비밀번호가 다릅니다.');
		}
	})

</script>







<script>
/* <form action="${context}/member.do" onsubmit="return sendForm()" method="get">
	아이디 입력 <br><input type="text" name="delete-id" /><br />
	 비밀번호 입력 <br><input type="text" name="delete-pw" /><br /> <br /> 
	 <input type="submit" value="회원탈퇴" /> 
	 <input type="hidden" name="action" value="delete" /> 
	 <input type="hidden" name="page" value="delete_result" />
</form> */


/* 	function sendForm() {
		alert('--sendForm 통과--');
		return true;
	} */
	
//===============================================================================================	
	/*
6단계) 정적 코딩제거하기 (★메소드나 function 내에서 해야함)
	(before - 정적코딩)
	<input type="hidden" name="action" value="delete" /> 
	<input type="hidden" name="page" value="delete_result" />
	
	방법1) JSP의 <script>에서 function()내에서 작업
	1-1)오리지날 -비추
	//1.createElement 2.innerHTML 3.appendChild
	var node = document.createElement('input');  //기존에 존재하는 input 생성 (create) //없는 존재를 태그로 만드는 것을 node라고 함.
	node.innerHTML = '<input type="hidden" name="action" value="delete" />'  //hidden 숨길 의도니까 html상에서 없애자
	form.appendChild(node); 		
	
	
	
	
	
	방법2)Java의 메소드() 내에서 작업
	//setPage(request.getParameter("page")가 아닌
	setPage("mypage");	//<-도착지 servlet이 결정하게하고 input삭제
	 */
	
	
</script>

</body>
</html>
