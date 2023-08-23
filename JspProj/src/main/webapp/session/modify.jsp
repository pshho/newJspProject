<%@page import="java.util.HashMap"%>
<%@page import="login.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session / modify</title>
</head>
<body>
	<h1>session / modify</h1>
	<%
		session.setAttribute("pname", "장서건");
		session.setAttribute("age", 30);		
	%>
</body>
</html>