<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 점수 계산</title>
</head>
<body>
	<form action="./studentProcess.jsp" name="qwer">
		<table border="">
			<thead>
				<tr>
					<td>이름</td><td>국어</td><td>영어</td><td>수학</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (int i=0; i<5; i++) { 
				%>
				<tr>
					<td><input type="text" name="std" /></td>
					<td><input type="text" name="kor" value="<%= (int)(Math.random()*100)+1 %>" /></td>
					<td><input type="text" name="eng" value="<%= (int)(Math.random()*100)+1 %>" /></td>
					<td><input type="text" name="math" value="<%= (int)(Math.random()*100)+1 %>" /></td>
				</tr>
				<% } %>
				<tr>
					<td colspan="4" align="right">
						<input type="submit" value="계산" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>