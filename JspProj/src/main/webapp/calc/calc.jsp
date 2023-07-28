<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	int cnt = 5;

	if(request.getParameter("cnt") != null){
		cnt = Integer.parseInt(request.getParameter("cnt"));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>짝수</title>
<script type="text/javascript">
	function cntChange(){
		let form = document.qwer;
		form.action="?";
		form.submit();
	}
</script>
</head>
<body>
	<%-- <%= cnt %> --%>
	<h2>짝수 계산</h2>
	<%-- <form action="./calcProcess.jsp"> 
		<c:forEach begin="1" end="20">	<!-- for문으로 입력받을 개수 지정 -->
			<input type="text" name="calc" value="<%= (int)(Math.random()*100)+10 %>"/><br/>
		</c:forEach>
		<br/>
		<input type="submit" value="제출" />
	</form> --%>
	
	<form action="./calcProcess.jsp" name="qwer">
		<table border="">
			<tr>
				<td colspan="2" align="right">
					칸수:
					<select name="cnt" id="" onchange="cntChange()">
						<% for (int i=5; i<=30; i+=5) {
							String sel = "";
							
							if(i == cnt){
								sel = "selected";
							}
						%>
							<option <%= sel %> ><%= i %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<%
				for(int i=0; i<cnt; i++){
			%>
			<tr>
				<td><%= i+1 %></td>
				<td><input type="text" name="calc" value="<%= (int)(Math.random()*100)+10 %>"/></td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="계산" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>