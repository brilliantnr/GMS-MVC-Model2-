<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="moveToAdminMain" >ADMIN</a></li>

	</ul>
</div>
<script>
document.getElementById('moveToAdminMain').addEventListener('click',function(){   //★ #은 id를 의미
	admin.check("${context}");
});




</script>
<script>
<%--
1)
<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li>
2)
<li><a onclick="move('admin','move','main')">ADMIN</a></li> 
--%>
</script>
