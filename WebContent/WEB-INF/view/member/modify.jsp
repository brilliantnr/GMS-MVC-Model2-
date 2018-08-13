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
			<td rowspan="3"><img src="resources/img/home/cat.jpg" alt="이미지"></td>
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
<form method="POST" enctype="multipart/form-data" action="${context}/member.do?action=fileupload&page=retrieve">
파일 업로드: <input type="file" name="upfile"><br/>
			<input type="submit" name="파일업로드"><br/>
			<!-- 
			<input type="hidden" name="action" value="fileupload">
			<input type="hidden" name="page" value="retrieve"> 
			-->
</form>
	<script>
	var form = document.getElementById('update_form');
	var team = document.getElementById('teamid');
	var roll = document.getElementById('roll');
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
</body>
</html>