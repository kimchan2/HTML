<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	[
    <%
    
		// SqlMapClient 객체 얻어오기
		SqlMapClient smc = SqlMapClientFactory.getClient();	
		
		// Sql문 SELECT 수행하기
		List<LprodVO> list = smc.queryForList("lprod.selectAll");
		
		// json배열 생성
		String str = "";
		for(int i = 0; i < list.size(); i++){
			
			LprodVO vo = list.get(i);
			if(i > 0) str += ",";
			str += "\"" + vo.getLprod_nm() + "\"";
		}
    %>
    <%= str %>
    ]
    