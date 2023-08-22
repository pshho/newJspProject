<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<h1>로그인 처리</h1>
	<%
		String dbid = "aaa", dbpw = "1234", dbPname= "장동건" ;
		String pid = request.getParameter("pid");
		String pw = request.getParameter("pw");
		
		String msg = "로그인 실패";
		
		if(pid.equals(dbid) && pw.equals(dbpw)){
			msg = dbPname + "로그인 성공";
			response.addCookie(new Cookie("pid", pid));
			response.addCookie(new Cookie("pname", dbPname));
		}
	%>
	<script type="text/javascript">
		alert("<%= msg %>");
		location.href = "logMain.jsp";
	</script>
</body>
</html>