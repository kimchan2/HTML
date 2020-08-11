<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String vid = request.getParameter("id");
	
	SqlMapClient smc = SqlMapClientFactory.getClient();

	MemberVO vo = (MemberVO)smc.queryForObject("member.getMemberById", vid);
	
	
%>

	{
		"id": "<%= vo.getMem_id()%>",
		"name": "<%= vo.getMem_name()%>",
		"hp": "<%= vo.getMem_hp()%>",
		"add1": "<%= vo.getMem_add1()%>",
		"add2": "<%= vo.getMem_add2()%>"
	}
