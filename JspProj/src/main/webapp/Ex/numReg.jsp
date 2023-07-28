<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>numReg</title>
</head>
<body>
<%
	String [] noArr = request.getParameterValues("no");

	int tot = 0;
	for (String str : noArr) {
		//System.out.println(str);
		
		try {
			int i = Integer.parseInt(str);
			
			//짝수냐? 짝수 더하기가 안됍니다. 여기좀 풀어주세요
			if(i % 2 == 0) {
				tot += i;
				//System.out.println("짝수만:"+i+","+tot);
			}
			
		} catch (Exception e) {
			
			//System.out.println("에러 글자였다:"+str);
		}
		
	}
%>
<h1>numReg</h1>
no:<%=request.getParameter("no") %><br/>
noArr:<%=Arrays.toString(noArr) %><br/>
tot:<%=tot %>
</body>
</html>