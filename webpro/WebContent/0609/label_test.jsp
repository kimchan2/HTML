<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/mycss.css">
<style>
	span{
		font-size : 1.5em;
		display : inline-block;
		margin : 6px;
		width : 150px;
		height : 40px;
		padding : 5px;
	}
	.uid{
		font-size : 2.5em;
		background : lightblue;
		color : blue;
		width : 450px;
	}
	table{
		border : 2px dotted blue;
	}
	td{
		width : 200px;
		height : 50px;
		text-align : center;
		font-size : 1.2em;
	}
</style>
</head>
<body>
	<h3>클라이언트 전송시 입력한 데이터 값을 전달 받는다</h3>
	<p>request.getParameter("name이름")</p>
	<%
		//클라이언트 전송시 입력한 데이터 값을 전달 받는다
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		out.print("<span>이름 : </span><span>" + name + "</span><br><span>아이디 : </span><span>" + id + "</span><br><span>전화번호 : </span><span>" + tel + "</span><br><span>주소 : </span><span>" + addr + "</span>");
		
	%>
	<br><br>
	<span class="uid"> <%= id %>님</span><span class="uid">좋은하루 되세요 </span>
	
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%= id %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= name %></td>
		</tr>
	
		<tr>
			<td>주소</td>
			<td><%= addr %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%= tel %></td>
		</tr>
	</table>
	
</body>
</html>