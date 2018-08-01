<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="../common/head.jsp" />
<title>관리자 페이지 - 회원 상세 정보</title>
</head>
<body>
	<div id="wrapper">
	<table id="mypage">
		<tr>
			<th>★★★★ ${retrieve.name}의 회원정보</th>
		</tr>
		<tr>
			<td>이름</td>
			<td>${retrieve.name}</td>
			<td rowspan="3">picture.jpg</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>*****</td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td>${retrieve.ssn}</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${retrieve.age}</td>
			<td></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${retrieve.gender}</td>
			<td></td>
		</tr>
		<tr>
			<td>팀명</td>
			<td>${retrieve.teamId}</td>
			<td></td>
		</tr>
		<tr>
			<td>역할</td>
			<td>${retrieve.roll}</td>
			<td></td>
		</tr>
	</table>

		<a id="mypage_to_update"> 수정하기 </a>
		<a id="mypage_to_delete"> 회원탈퇴하기 </a>
</div>

	<script>

		//session 있음으로서 request.getParameter()쓸 필요없다.
		//톰켓이 가지고 있는 reqeust. 이런 것들은 서블릿또는 JSP에서 이루어져야함
		//update - 비번, 팀명, 팀롤
		//업데이트 버튼 - 수정하기
		document.getElementById('mypage_to_update').addEventListener('click',
				function() {
					router.move({
						context : '${context}',
						domain : 'member',
						action : 'move',
						page : 'update_form'
					});
				});
		
		document.getElementById('mypage_to_delete').addEventListener('click',function(){
			router.move({context:'${context}',
				domain:'member',
				action:'move',
				page:'delete_form'});
		});
	</script>

</body>
</html>
