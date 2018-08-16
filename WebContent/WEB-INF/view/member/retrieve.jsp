<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="contentBox">
	<table id="mypage">
		<tr>
			<th>${user.name}의  회원정보</th>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
			<td id="mypageImg" rowspan="3">
				<img src="${img}/${imgPath}" alt="이미지">
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>*****</td>
		</tr>
		<tr>
			<td>생년월일</td>
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
			<td>팀명</td>
			<td>${user.teamId}</td>
			<td></td>
		</tr>
		<tr>
			<td>역할</td>
			<td>${user.roll}</td>
			<td></td>
		</tr>
	</table>
		<a id="mypage_update"> 수정하기 </a>
		<a id="mypage_delete"> 회원탈퇴하기 </a>
</div><!-- content -->

	<script>
		//session 있음으로서 request.getParameter()쓸 필요없다.
		//톰켓이 가지고 있는 reqeust. 이런 것들은 서블릿또는 JSP에서 이루어져야함
		//update - 비번, 팀명, 팀롤
		//업데이트 버튼 - 수정하기
		document.getElementById('mypage_update').addEventListener('click',
				function() {
					router.move({
						context : '${context}',
						domain : 'member',
						action : 'move',
						page : 'modify'
					});
				});
		
		document.getElementById('mypage_delete').addEventListener('click',function(){
			router.move({context:'${context}',
				domain:'member',
				action:'move',
				page:'remove'});
		});
		
		
	</script>
</body>
</html>
