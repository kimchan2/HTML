<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8"); // post 에서 인코딩 설정
											   // get에서는 서버의 server.xml 파일의 65번라인 으로 설정
		
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
	%>
	
	<%= userId %>님 환영합니다<br>
	<%= userName %>님 즐거운 하루 되세요<br>
</body>
</html>