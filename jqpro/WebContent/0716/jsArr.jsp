<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	SqlMapClient smc = SqlMapClientFactory.getClient();

	List<MemberVO> list = smc.queryForList("member.getMemberAll");

	String str = "";
	for(int i = 0; i < list.size(); i++){
		MemberVO vo = list.get(i);
		if(i > 0) str += ",";
		str += "\"" + vo.getMem_name() + "\"";
	}
%>

<%= str %>

]