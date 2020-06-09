<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	span{
		color : orange;
		font-size : 1.5em;
	}
	.uid{
		color : lightblue;
	}
	.mess{
		color : green;
	}
</style>
</head>
<body>
	<p>클라이언트 전송(요청)시 id와 pass를 가져온다</p>
	<p>post방식으로 데이터를 전달받는다</p>
	<%
		request.setCharacterEncoding("UTF-8"); // post방식에서 한글을 사용하기, server에 지정해준 UTF-8이 안먹힘
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
		
		//db와 연결해서 CRUD
		//작업한 결과를 출력한다
		out.print("<span class='uid'>" + userId + "</span>님 <span class='mess'>즐거운 하루 되세욬</span><br>");
	%>
	<br>
	<br>
	<span class="uid"> <%= userId %> </span> 님  <span class="mess">행복하세요 </span>
</body>
</html>