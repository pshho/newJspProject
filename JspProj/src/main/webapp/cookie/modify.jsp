<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수정</title>
</head>
<body>
	<h1>쿠키 수정</h1>
	<%
		Cookie coo1 = new Cookie("pname", "bbb");
		Cookie coo2 = new Cookie("marriage", "true");
		
		response.addCookie(coo1);
		response.addCookie(coo2);
	%>
</body>
</html>