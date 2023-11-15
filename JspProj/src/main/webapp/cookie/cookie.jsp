<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 테스트</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies.length > 0){
			String name = cookies[0].getName();
			String value = cookies[0].getValue();
		}
	%>
</body>
</html>