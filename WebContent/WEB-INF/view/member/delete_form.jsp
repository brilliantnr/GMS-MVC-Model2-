<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>

<h3> 회원 탈퇴 </h3>
<form action="<%=ctx %>/member.do">
아이디 입력		<br /><input type="text" name="delete-id" /><br />
비밀번호 입력		<br /><input type="text" name="delete-pw"/><br />
 <br /><input type="submit" value="회원탈퇴"/>
 <input type="hidden" name="action" value="delete"/>
 <input type="hidden" name="page" value="delete_result"/>
</form>