<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int seq = (Integer)request.getAttribute("seqval");

	if(seq > 0){%>
		
		{ "sw" : "<%= seq %>번 저장 성공" }
				
	<%}else{%>

		{ "sw" : "<%= seq %>번 저장 실패" }
		
	<%}
%>    