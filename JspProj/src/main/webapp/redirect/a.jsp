<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a</title>
</head>
<body>
	<h2>redirect > a</h2>
	<script type="text/javascript">
		alert("난 a");
		location.href="b.jsp";
	</script>
	<%
		request.setAttribute("pname", "aaa");
		response.sendRedirect("b.jsp?age=26");
	%>
</body>
</html>