<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키</title>
</head>
<body>
	<h1>쿠키 삭제</h1>
	<%
		String fiveEnc = URLEncoder.encode("5초 뒤 사라짐", "utf-8");
		Cookie coo1 = new Cookie("pname", "bbb");
		Cookie coo2 = new Cookie("marriage", fiveEnc);
		coo1.setMaxAge(0);
		coo2.setMaxAge(5);
		
		response.addCookie(coo1);
		response.addCookie(coo2);
	%>
</body>
</html>