<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content-box">
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
document.getElementById('content_box_meta').className='bgColorisYellow'; //style.css에서 설정한 .bgColorisYellow로 설정
var x = document.querySelectorAll('.username');  //.은 class
//object와 array가 있는 2차원에서의 단수: object, 복수:Array 
//=> 따라서 x는 array(왜냐면 All로 선택하니까)
//톰켓에서 가장큰게 application . 톰켓의 벡터
for(i in x){
	x[i].style.color='blue';  //x[i]는 object(x가 array이니까)
	x[i].style.cursor ='pointer';
	x[i].addEventListener('click',function(){
		alert('클릭 '+this.getAttribute('id'));  //★★★★ this는 콜백function을 불러낸 x[i]를 말한다
		location.href='${context}/admin.do?action=retrieve&page=member_de tail&userid='+this.getAttribute('id');
	});
}





/*이렇게 살지말자...ㅋ.ㅋ 올드해
<td><a href="${context}/admin.do?action=retrieve&page=member_detail&userid=${m.userid}" style="cursor: pointer;">${m.name}</a></td>
a태그에 style, href 잘 안쓴다.
*/
</script>