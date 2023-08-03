<%@page import="JspProject.ResidentNumber" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민번호 입력</title>
</head>
<body>
	<form action="?" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" id="name">
		<br/><label>주민번호</label>
		<input type="text" name="frontNumber" maxlength="6">
		<input type="text" name="backNumber" maxlength="7">
		<input type="submit" value="제출">
	</form>
	
	<%
		String fN = request.getParameter("frontNumber");
		String bN = request.getParameter("backNumber");
		String name = request.getParameter("name");
		
		if(fN != null && bN != null){
			ResidentNumber rN = new ResidentNumber(fN, bN);
			
			response.sendRedirect(rN.getDomeForeign()+"Signup.jsp?name=" + name + "&fN=" + fN + "&bN=" + bN);
		}
	%>
</body>
</html>