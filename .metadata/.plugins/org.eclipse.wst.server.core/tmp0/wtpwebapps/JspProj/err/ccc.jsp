<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ccc 500</title>
</head>
<body>
	<h2>ccc 500</h2>
	<%
		int a = 10/0;
	
		out.println("정상 실행 1 " + a + "<br/>");
	%>
</body>
</html>