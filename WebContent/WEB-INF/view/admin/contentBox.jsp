<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl.jar 사용하기 위한 것 -->

<div id="content-box">
	<div id="search_div">
		<select id="search_box" name="search_box" >
			<option value="search_option">검색조건</option>
			<option value="userid">아이디</option>
			<option value="name">이름 </option>
			<option value="teamname">팀명</option>
		</select>
		<input id="search_word" type="text" placeholder="검색어 입력"/>
		<input id="search_btn" type="button" value="검색" />
	</div>
<table id="content_box_table">
	<tr id="content_box_meta">
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
		<td><a class="username" id="${m.userid}">${m.name}</a></td>
		<td>${m.age}</td>
		<td>${m.gender}</td>
		<td>${m.roll}</td>
		<td>${m.teamId}</td>
	</tr>
 	</c:forEach>
</table>
</div>
<script>
admin.main('${context}');



/*이렇게 살지말자...ㅋ.ㅋ 올드해
<td><a href="${context}/admin.do?action=retrieve&page=member_detail&userid=${m.userid}" style="cursor: pointer;">${m.name}</a></td>
a태그에 style, href 잘 안쓴다.
*/
</script>