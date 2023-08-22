<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 View</title>
</head>
<body>
	<h1>쿠키 View</h1>
	<%
		Cookie[] coos = request.getCookies();
	
		for(Cookie co : coos){
	%>
	<%= co.getName() %> : <%= URLDecoder.decode(co.getValue(), "utf-8") %><br />
	<%	
		}
	%>
</body>
</html>