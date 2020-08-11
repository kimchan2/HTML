<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%
	List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("listval");
	for(int i = 0; i < list.size(); i++){
		ReplyVO vo = list.get(i);
		if(i > 0) out.print(",");
		String cont = vo.getCont().replaceAll("\r", "").replaceAll("\n", "<br>");
%>
		{
			"renum": "<%= vo.getRenum() %>",
			"bonum": "<%= vo.getBonum() %>",
			"name": "<%= vo.getName() %>",
			"cont": "<%= cont %>",
			"redate": "<%= vo.getRedate() %>"
		}
	<%}
%>
]