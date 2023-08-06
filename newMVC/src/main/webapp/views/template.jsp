<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template</title>
</head>
<% String boardJspPage = "board/"+request.getAttribute("boardJspPage")+".jsp"; %>
<body>
	<table border="">
		<tr>
			<td><jsp:include page="Inc/header.jsp" /></td>
		</tr>
		<tr>
			<td><jsp:include page="<%= boardJspPage %>"/></td>
		</tr>
		<tr>
			<td><jsp:include page="Inc/footer.jsp" /></td>
		</tr>
	</table>
</body>
</html>