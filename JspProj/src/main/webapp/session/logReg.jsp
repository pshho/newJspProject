<%@page import="login.MemberCheck"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="login.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session / logReg</title>
</head>
<body>
	<h1>로그인 처리</h1>
	<%
		Member mb1 = new Member("aa", "12", "김태리");
		Member mb2 = new Member("bb", "34", "한효주");
		Member mb3 = new Member("cc", "56", "고아라");
		Member mb4 = new Member("dd", "78", "류혜영");
		Member mb5 = new Member("ee", "90", "김승화");
		
		MemberCheck mk = new MemberCheck(mb1, mb2, mb3, mb4, mb5);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String msg = "로그인 실패";
		
		if(mk.getCheck().containsKey(id) && mk.getCheck().get(id).getPw().equals(pw)){
			session.setAttribute("id", id);
			session.setAttribute("name", mk.getCheck().get(id).getName());
			msg = "로그인 성공";
		}
				
	%>
	<script type="text/javascript">
		alert("<%= msg %>");
		location.href="logMain.jsp";
	</script>
</body>
</html>