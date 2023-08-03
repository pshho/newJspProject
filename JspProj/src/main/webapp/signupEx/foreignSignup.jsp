<%@page import="JspProject.ResidentNumber"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외국인 회원가입</title>
</head>
<body>
	<%
		String fN = request.getParameter("fN");
		String bN = request.getParameter("bN");
		ResidentNumber rN = null;
		
		if(fN != null && bN != null){
			rN = new ResidentNumber(fN, bN);
		}
	%>
	<h2>외국인 회원가입</h2>
	<form action="">
		<ul>
			<li><label>아이디</label><input type="text" name="id" value="<%= request.getParameter("name") %>"></li>
			<li><label>비밀번호</label><input type="password" name="pw"></li>
			<li>
				<label>생년월일</label>
				<% for(int i=0; i<rN.getFrontNumber().length; i++) { %>
				<input type="text" name="birth" value="<%= rN.getFrontNumber()[i] %>">
				<% } %>
			</li>
			<li><input type="submit" value="제출"></li>
		</ul>
	</form>
</body>
</html>