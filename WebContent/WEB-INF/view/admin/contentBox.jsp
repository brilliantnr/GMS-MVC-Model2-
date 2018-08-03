<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- jstl.jar 사용하기 위한 것 -->

<div id="content-box">
	<div id="search_div">
		<input id="search_btn" type="button" value="검색" /> 
		<input id="search_word" type="text" placeholder="검색어 입력" /> 
		<select id="search_box" name="search_box">
			<option value="search_option">검색조건</option>
			<option value="userid">아이디</option>
			<option value="name">이름</option>
			<option value="teamname">팀명</option>
		</select>
	</div>
	<table id="content_box_table">
		<tr id="content_box_meta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 할</th>
			<th>팀 명</th>
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
		<tr>
			<td colspan="6">
 				전체회원수 : ${count}
 				<br />
			<c:forEach begin="1" end="${listpage}" step="1" var="i" ><%--${Math.ceil(list.size()/5)} 스크립틀릿 영역에서 연산하는게 깨끗하지 않다  --%>
				<span>${i}</span>
			</c:forEach>
			</td>
		</tr>
	</table>
</div>
<script>
admin.main('${context}');


//회원수가 수백만명 될 수 있으니까 전체 리스트를 가져올수가없다  list.size() 노노

/*이렇게 살지말자...ㅋ.ㅋ 올드해
<td><a href="${context}/admin.do?action=retrieve&page=member_detail&userid=${m.userid}" style="cursor: pointer;">${m.name}</a></td>
a태그에 style, href 잘 안쓴다.
*/
</script>