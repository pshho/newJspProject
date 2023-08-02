<%@page import="JspProject.ResidentNumber"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String fN = request.getParameter("fN");
		String bN = request.getParameter("bN");
		String birth = null;
		
		if(fN != null && bN != null){
			ResidentNumber rN = new ResidentNumber(fN, bN);
			
			birth = rN.getBirth();
		}
	%>
	<h2>미성년자 회원가입</h2>
	<form action="">
		<ul>
			<li><label>아이디</label><input type="text" name="id" value="<%= name %>"></li>
			<li><label>비밀번호</label><input type="password" name="id"></li>
			<li><label>생년월일</label><input type="date" value="<%= birth %>"></li>
			<li><input type="submit" value="제출"></li>
		</ul>
	</form>
</body>
</html>