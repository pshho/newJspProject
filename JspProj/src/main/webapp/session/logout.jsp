<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session / logout</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<script type="text/javascript">
		alert("로그아웃 성공");
		location.href="logMain.jsp";
	</script>
</body>
</html>