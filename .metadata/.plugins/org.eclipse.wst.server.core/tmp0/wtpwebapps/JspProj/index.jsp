<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspProj 입니다.</title>
</head>
<body>
	<h1>jspProj 입니다.</h1>
	<h2>basic</h2>
	<h3>안녕</h3>
	<a href="basic/First">서블릿 진입</a><br/>
	<a href="basic/03_third.jsp">jsp</a><br/>
	<a href="basic/04_page.jsp">page</a><br/>
	<a href="basic/05_config.jsp">config</a><br/>
	<a href="basic/06_pageContext.jsp">pageContext</a><br/>
	<h2>Exception</h2>
	<a href="err/aaa.jsp">try ~ catch</a><br/>
	<a href="err/bbb.jsp">errorPage</a><br/>
	<a href="err/ccc.jsp">500</a><br/>
	<a href="err/ddd.jsp">404</a><br/>
	<a href="err/eee.jsp">type</a><br/>
	<h2>Calc</h2>
	<a href="calc/calc.jsp">짝수 계산</a>
	<h2>점수 계산</h2>
	<a href="hwProject/categories">점수 계산</a>
	<h2>forward, include, redirect</h2>
	<a href="redirect/a.jsp?nick=ccc">redirect</a><br/>
	<a href="forward/a.jsp?nick=eee">forward</a><br/>
	<a href="include/a.jsp?nick=fff">include</a><br/>
	<h2>주민번호</h2>
	<a href="signupEx/resident.jsp">주민번호</a>
	<h2>쿠키</h2>
	<a href="cookie/make.jsp">쿠키 생성</a>
	<a href="cookie/view.jsp">쿠키 View</a>
	<a href="cookie/modify.jsp">쿠키 수정</a>
	<a href="cookie/delete.jsp">쿠키 삭제</a>
	<a href="cookie/logMain.jsp">로그인</a>
	<h3>쿠키 - 로그인</h3>
	<a href="loginOut/login.jsp">로그인</a>
	<h3>세션</h3>
	<a href="session/make.jsp">make</a>
	<a href="session/view.jsp">view</a>
	<a href="session/modify.jsp">modify</a>
	<a href="session/delete.jsp">delete</a>
	<a href="session/logMain.jsp">로그인 메인</a>
</body>
</html>