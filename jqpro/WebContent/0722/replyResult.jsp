<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int count = (Integer)request.getAttribute("countvalue");

	if(count > 0){
%>
	{"sw": "실행 성공"}

<%	}else{ %>

	{"sw": "실행 실패"}
	
<%	} %>


