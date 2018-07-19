<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=java.util.*
import=domain.*
 %>
<% 
	String ctx = application.getContextPath();
%>
<%
List<MemberBean> lst = (List<MemberBean>)request.getAttribute("list");
%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<style>
	.tbl {border:1px solid black}
	.tbl tr{border:1px solid black}
	.tbl tr td{border:1px solid black}
	</style>
</head>
<body><form action="<%=ctx %>/member.do">
	<table class="tbl">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>팀명</td>
		<td>나이</td>
		<td>직책</td>
		
	</tr>
		<%
		for(MemberBean m : lst){
		%><tr>
		<td><%=m.getUserid()%></td>
		<td><%=m.getName()%></td>
		<td><%=m.getTeamId()%></td>
		<td><%=m.getAge()%></td>
		<td><%=m.getRoll()%></td>
		</tr>
		<%
			}
		%>
</table>
</form>
</body>
</html>

