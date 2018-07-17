<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title> Hello</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<h3>현재 회원수 : <mark>20명</mark></h3>
	<table id="main-tab-layout"
		class="witdh-full height-100 margin-auto color-bg">
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td class="witdh-full height-300"><img
				src="resources/img/home/gorae.jpg" alt="" /></td>
			<td id="login" class="color-lg">
				<ul>
					<li><a href="<%=ctx %>/member.do?action=move&page=join_form">회원가입 </a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=user_login_form">사용자로그인</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=admin_login">관리자로그인</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=member_list">리스트</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=update_form"> 비밀번호 변경</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=delete_form">회원 탈퇴</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=search_team_form">팀이름 검색</a></li>
					<li><a href="<%=ctx %>/member.do?action=move&page=search_id_form">아이디 검색</a></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<p>
					<span class="first">© Kakao M Corp.All rights reserved.</span>
				</p>
			</td>
		</tr>
	</table>

</body>
</html>