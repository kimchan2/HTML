<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[
<%
   List<BoardVO> list =  (List<BoardVO>)request.getAttribute("listval");

   for(int i = 0 ; i < list.size(); i++){
      BoardVO vo = list.get(i);
      if(i > 0) out.print(",");
      String cont = vo.getContent().replaceAll("\r", "")
    		                       .replaceAll("\n", "<br>");
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