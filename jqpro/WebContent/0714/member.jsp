<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 주석 --%>

[
<% // 자바 스크립트 릿(조각)

	// ibatis mapper파일 실행하기 위해서 SqlMapClient가 필요
	SqlMapClient client = SqlMapClientFactory.getClient();
	
	// member2.xml의 select구문을 실행한다 - namespace이름.id이름
	List<MemberVO> list = client.queryForList("member.getMemberAll");
	
	for(int i = 0; i<list.size(); i++){
		
		MemberVO vo = list.get(i);
		if(i > 0) out.print(",");
%>		
		{
			"id"	: "<%= vo.getMem_id() %>",
			"name"	: "<%= vo.getMem_name() %>",
			"hp"	: "<%= vo.getMem_hp() %>",
			"mail"	: "<%= vo.getMem_mail() %>",
			"addr"	: "<%= vo.getMem_add1() %> <%= vo.getMem_add2() %>"
		}
<%	
	}
%>
] 