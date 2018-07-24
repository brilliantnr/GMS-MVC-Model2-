<%@page import="domain.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
    MemberBean user = (MemberBean)request.getAttribute("user");
%>
<h1><%=user.getName() %> 의 마이페이지 진입</h1>
<h3><%=request.getAttribute("user") %></h3>