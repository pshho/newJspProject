<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<h1>로그아웃</h1>
	<%
		Cookie[] coos = request.getCookies();
		String name = null;
		
		for(Cookie co : coos){
			if(co.getName().equals("name")){
				name = co.getValue();
			}
		}
		
		Cookie coo = new Cookie("id", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		coo = new Cookie("name", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
	%>
	<script type="text/javascript">
		alert("<%=name%>");
		location.href = "login.jsp";
	</script>
</body>
</html>