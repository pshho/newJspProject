<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b</title>
</head>
<body>
	<h2>forward > b</h2>
	<script type="text/javascript">
		alert("난 b");
	</script>
	
	<p>pname: <%= request.getAttribute("pname") %></p>
	<p>age: <%= request.getParameter("age") %></p>
	<p>nick: <%= request.getParameter("nick") %></p>
</body>
</html>