<%@page import="login.Member"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session / view</title>
</head>
<body>
	<h1>session / view</h1>
	<%
		Member mb = (Member)session.getAttribute("per");
	%>
	pname : <%= session.getAttribute("pname") %>
	no : <%= session.getAttribute("no") %>
	arr : <%= Arrays.toString((int[])session.getAttribute("arr")) %>
	per : <%= mb %>
</body>
</html>