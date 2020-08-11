<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
<%

	String id = (String)request.getAttribute("insertId");
	
	if(id != null){
%>		
	{ "sw": "<%= id %>님 가입 성공"}
	<%}else{%>
	{ "sw": "<%= id %>님 가입 실패"}
	<%}

%>