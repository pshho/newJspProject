<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 처리</title>
</head>
<body>
	<h1>로그아웃 처리</h1>
	<%
		Cookie[] coos = request.getCookies();
	
		String pname = null;
		
		for(Cookie co : coos){
			if(co.getName().equals("pname")){
				pname = co.getValue();
			}
		}
		
		Cookie coo = new Cookie("pid", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
		coo = new Cookie("pname", "");
		coo.setMaxAge(0);
		response.addCookie(coo);
	%>
	<script type="text/javascript">
		alert("<%=pname%>");
		location.href = "logMain.jsp";
	</script>
</body>
</html>