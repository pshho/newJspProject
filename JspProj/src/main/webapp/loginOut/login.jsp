<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		Cookie[] coos = request.getCookies();
		String id = null, name = null;
		
		for(Cookie co : coos){
			if(co.getName().equals("id")){
				id = co.getValue();
			}
			
			if(co.getName().equals("name")){
				name = co.getValue();
			}
		}
		
		if(id != null){
	%>
	<%= name %>님 안녕하세요.
	<a href="logout.jsp">로그아웃</a>
	<%} else { %>
	<form action="loginReg.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
	<%} %>
</body>
</html>