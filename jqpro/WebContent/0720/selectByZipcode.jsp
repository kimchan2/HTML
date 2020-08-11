<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%

	List<ZipVO> list = (List<ZipVO>)request.getAttribute("listval");

	for(int i = 0; i < list.size(); i++){
		ZipVO vo = list.get(i);
		if(i > 0) out.print(",");
		
		String bunji = vo.getBunji();
		if(bunji == null) bunji = "";
		
		String addr = vo.getSido() + " " + vo.getGugun() + " " + vo.getDong();
%>		
	{
		"Addr": "<%= addr %>",
		"Bunji": "<%= bunji %>",
		"Zipcode": "<%= vo.getZipcode() %>"
	}
<%
	}
	
%>
]