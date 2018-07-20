<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>MYPAGE</title>
<link rel="stylesheet" href="../../css/home/style.css" />
</head>
<body>
	<table id="main-tab-layout"
		class="witdh-full height-100 margin-auto color-bg">
		<tr>
			<td colspan="2"><h1>GMS</h1></td>
		</tr>
		<tr>
			<td class="witdh-full height-300">
			<% MemberBean user = (MemberBean)request.getAttribute("user"); %> 
  		 <h1><%= user.getName() %>의 마이페이지 진입</h1>
			</td>
			<td class="color-lg"><a href="../../main.jsp">로그아웃</a></td>
		</tr>
		<tr>
			<td colspan="2">
				<p>
					<span class="first">(주) 카카오 M</span> 
				</p>
			</td>
		</tr>
	</table>
</body>
</html>