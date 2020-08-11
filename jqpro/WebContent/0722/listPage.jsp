<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	
	List<BoardVO> list =  (List<BoardVO>)request.getAttribute("listval");
	int startPage = (Integer)request.getAttribute("startPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int totalPage = (Integer)request.getAttribute("totalPage");
	int currentPage = (Integer)request.getAttribute("currentPage");
	
%>

{
	"totalPage": "<%= totalPage %>",
	"startPage": "<%= startPage %>",
	"endPage": "<%= endPage %>",
	"currentPage": "<%= currentPage %>",
	"listdata" : [
	
		<%
  	 	for(int i = 0 ; i < list.size(); i++){
      		BoardVO vo = list.get(i);
      		if(i > 0) out.print(",");
      	%>
	      	{
	         "mail" : "<%= vo.getMail() %>",
	         "pass" : "<%= vo.getPassword() %>",
	         "content" : "<%= vo.getContent() %>",
	         "hit" : "<%= vo.getHit() %>",
	         "seq" : "<%= vo.getSeq() %>",
	         "subject" : "<%= vo.getSubject() %>",
	         "wdate" : "<%= vo.getWdate() %>",
	         "wip" : "<%= vo.getWip() %>",
	         "writer" : "<%= vo.getWriter() %>"
	      	}
	    <%
   		}
		%>
	]
}
