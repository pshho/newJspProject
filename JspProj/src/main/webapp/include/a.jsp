<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a</title>
</head>
<body>
	<h2>include > a</h2>
	<script type="text/javascript">
		alert("난 a");
	</script>
	<%
		request.setAttribute("pname", "ddd");
	%>
	<jsp:include page="b.jsp?age=44"/>
</body>
</html>