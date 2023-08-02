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
	<form action="" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" id="name">
		<br/><label>주민번호</label>
		<input type="number" name="frontNumber" maxlength="6">
		<input type="number" name="backNumber" maxlength="7">
		<input type="submit" value="제출">
	</form>
	
	<%
		String fN = request.getParameter("frontNumber");
		String bN = request.getParameter("backNumber");
		String name = request.getParameter("name");
		
		if(fN != null && bN != null){
			ResidentNumber rN = new ResidentNumber(fN, bN);
			
			String rfN = rN.getFrontNumber();
			String rbN = rN.getBackNumber();
			
			if(rbN.equals("5") || rbN.equals("7") ||
				rbN.equals("6") || rbN.equals("8")){
				response.sendRedirect("foreignSingup.jsp?name=" + name + "&fN=" + fN + "&bN=" + bN);
			}else{
				if(Integer.parseInt(rfN) > 19){
					request.setCharacterEncoding("utf-8");
					response.sendRedirect("generalSignup.jsp?name=" + name + "&fN=" + fN + "&bN=" + bN);
				}else if(Integer.parseInt(rfN) <= 19){
					response.sendRedirect("minoritySingup.jsp?name=" + name + "&fN=" + fN + "&bN=" + bN);
				}				
			}
		}
	%>
</body>
</html>