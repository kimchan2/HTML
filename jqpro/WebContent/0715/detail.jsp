<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 요청시 전송되는 데이터 id값을 가져온다
	String str = request.getParameter("id");
	
	// SqlMapClient 객체 얻어오기
	SqlMapClient smc = SqlMapClientFactory.getClient();
	
	// 맵퍼의 sql쿼리를 수행 하기
	BuyerVO vo = (BuyerVO)smc.queryForObject("buyer.detailById", str);
	
	// json object 생성
%>
{
	"id": "<%= vo.getBuyer_id() %>",
	"name": "<%= vo.getBuyer_name() %>",
	"lgu": "<%= vo.getBuyer_lgu() %>",
	"mail": "<%= vo.getBuyer_mail() %>",
	"comtel": "<%= vo.getBuyer_comtel() %>",
	"bank": "<%= vo.getBuyer_bank() %>",
	"bno": "<%= vo.getBuyer_bankno() %>",
	"addr": "<%= vo.getBuyer_add1() %>"
}
