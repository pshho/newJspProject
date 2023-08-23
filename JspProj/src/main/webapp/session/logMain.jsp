<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session / logMain</title>
</head>
<body>
	<%
		String id = session.getAttribute("id")+"";
		String name = session.getAttribute("name")+"";
	%>
	<h1>로그인</h1>
	<c:choose>
		<c:when test="${ id eq null }">
			<form action="logReg.jsp">
				<table border="">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="text" name="pw" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input type="submit" value="로그인" />
						</td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<table border="">
				<tr>
					<td>${ name }님 안녕하세요</td>
				</tr>
				<tr>
					<td>${ id } <a href="logout.jsp">로그아웃</a></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>