<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[

<%

	// SqlMapClient 객체 가져오기
	SqlMapClient smc = SqlMapClientFactory.getClient();

	// 결과값 = sql 쿼리문 수행 하기
	List<BuyerVO> list = smc.queryForList("buyer.selectByName");
			
	// json object 데이터 생성{}
	for(int i = 0; i < list.size(); i++){
		BuyerVO vo = list.get(i);
		if(i > 0) out.print(",");
%>		
		{
			"id": "<%= vo.getBuyer_id() %>",
			"name": "<%= vo.getBuyer_name() %>"
		}
<% 
	}
%>	

]