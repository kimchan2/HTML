<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("listval");
	
	if(list == null || list.size() < 1){
		// 데이터가 없다
%>

	{
		"sw": "no"
	}

<%
	}else{
		// 데이터가 있다
%>
	{
		"sw": "ok",
		"data": [
		
			<%
				for(int i = 0; i<list.size(); i++){
					ProdVO vo = list.get(i);
					if(i > 0) out.print(",");
			%>
				{
					"id": "<%=vo.getProd_id()%>",
					"name": "<%=vo.getProd_name()%>"
				}
			<%
				}				
			%>
		
		]
	}


<%
	}
		
%>
