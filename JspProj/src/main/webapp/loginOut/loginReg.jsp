<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="login.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
		Member member1 = new Member("aaa", "1111", "장동건");
		Member member2 = new Member("bbb", "2222", "장서건");
		Member member3 = new Member("ccc", "3333", "장동건");
		Member member4 = new Member("ddd", "1111", "장남건");
		Member member5 = new Member("eee", "3333", "북두신건");
		List<Member> arrMem = new ArrayList<>();
		arrMem.add(member1);
		arrMem.add(member2);
		arrMem.add(member3);
		arrMem.add(member4);
		arrMem.add(member5);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String msg = "로그인 실패";
		
		for(Member mem : arrMem){
			if(mem.getIdPw().get(id) != null &&
					mem.getIdPw().get(id).equals(pw)){
				msg = mem.getName() + " 로그인 성공";
				response.addCookie(new Cookie("id", id));
				response.addCookie(new Cookie("name", mem.getName()));
			}
		}
	%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href="login.jsp";
	</script>
</body>
</html>