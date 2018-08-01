<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <div id="content-box">

<table>
	<tr>
		<th>아이디</th>
		<th>이   름</th>
		<th>나   이</th>
		<th>성   별</th>
		<th>역   할</th>
		<th>팀   명</th>
	</tr>
	<c:forEach items="${list}" var="m">
	<tr>
		<td>${m.userid}</td>
		<td><a id="admin_to_detail" style="cursor: pointer;">${m.name}</a></td>
		<td>${m.age}</td>
		<td>${m.gender}</td>
		<td>${m.roll}</td>
		<td>${m.teamId}</td>
	</tr>
	</c:forEach>
</table>
			
</div>
<script>
document.getElementById('admin_to_detail').addEventListener('click',function(){
	router.move(
	{context:'${context}',
		domain:'member',
		action:'search',
		page:'main'
		}		
	);
});


/* alert("회원목록이 보이면 된당 : ${list} "); */
/* Property 'teamid' not found on type domain.MemberBean */
/* <c:forEach items="${list}" var="m" > 에서 var는 임시적으로 변수 선언하는 거라서 */
/* ${list}는 request가 가진 값 */




</script> --%>