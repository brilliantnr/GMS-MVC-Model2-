<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<jsp:include page="../common/head.jsp"/>
<title>회원정보 수정하기</title>
</head>
<body>
<div>
	<form id="update_form" name="update_form">
	<table id="mypage">
		<tr>
			<th>${user.name}님의 회원정보</th>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
			<td rowspan="3">picture.jpg</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td> <input type="text" name="update_pw" placeholder="${user.password}" /><br /></td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td>${user.ssn}</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${user.age}</td>
			<td></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${user.gender}</td>
			<td></td>
		</tr>
				<tr>
					<td>팀명 (현재: ${user.teamId})</td>
					<td colspan="2">
					<select name="teamid" id="teamid">
							<option value="A">놀자</option>
							<option value="H">지은집</option>
							<option value="S">터틀킹</option>
							<option value="C">코딩짱</option>
					</select></td>
				</tr>
				<tr>
					<td>역할 (현재: ${user.roll})</td>
					<td colspan="2"><br>
					<select id="roll" name="roll">
							<option value="leader">팀장</option>
							<option value="front">프론트개발</option>
							<option value="back">백단개발</option>
							<option value="android">안드로이드개발</option>
							<option value="minfe">민폐</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="hidden" name="page" value="mypage" />
		<input type="hidden" name="action" value="update"/>	
		<input id="update_form_btn" type="button" value="회원정보 수정완료" /> 
	</form>
</div>
	<script>
	//DOM 객체 - document의 object로 만든 객체
	// BOM 객체 : location은 window(브라우저)의 것
	//jsp와 서블릿에서의 객체 = 
	var form = document.getElementById('update_form');
	var team = document.getElementById('teamid');
	var roll = document.getElementById('roll');
	//form과 team 자동으로 dom객체
	for(var i=0; i<team.options.length;i++){
		//alert('---'+team.options[i].value+'와 같다!');		
		if(team.options[i].value==='${user.teamId}'){   //loginCommand에서 user를 memberBean으로 지정
			//alert('---'+team.options[i].value );
			team.options[i].setAttribute("selected","selected");
		}
	}
	
	for(var i=0; i<roll.options.length;i++){
		//alert('---'+roll.options.length);
		if(roll.options[i].value==='${user.roll}'){
			//alert('---'+roll.options[i].value);
			roll.options[i].setAttribute("selected","selected");
		}
	}
	
	
	
		document.getElementById('update_form_btn').addEventListener('click',
				function() {
					var form = document.getElementById('update_form');
					alert('----update 확인 버튼 클릭----');
					if (form.update_pw.value === "") {
						form.update_pw.value = ${user.password};
					}
				form.action="${context}/member.do";
				form.method="post";
				form.submit();
				});
	</script>


























	<script>
	
	
	
	
	
	
	/*<form action="${context}/member.do" onsubmit="return sendForm()" method="get" >
		<h3>비밀번호 변경</h3>
		아이디 입력 <br> <input type="text" name="update-check-id" /><br />
		기존 비밀번호 입력 <br> <input type="text" name="update-old-password" /><br />
		새로운 비밀번호 입력 <br> <input type="text" name="update-new-password" /><br />
		<input id="update_form_btn" type="button" value="회원정보 수정완료" /> 
		<input type="hidden" name="action" value="update" /> 
		<input type="hidden" name="page" value="mypage" />
		</form>
	 */
	/* function sendForm() {
		alert('--sendForm 통과--');
		return true;
	} */
</script>
</body>
</html>


