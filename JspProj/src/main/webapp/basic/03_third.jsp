<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_third</title>
</head>
<body>
	<h1>03_third</h1>
	<%!
		// declaration : 클래스 정의부
		
		// 멤버 변수
		String name = "문어";
		int age = 49;
		boolean marriage = true;
		
		void meth_1() {
			System.out.println("meth_1() 실행");
		}
		
		// System.out.println("정의부에서 실행구문 불가");
		
		public void jspInit() {
			System.out.println("jspInit() 실행");
		}
		
		public void jspdestroy() {
			System.out.println("jspDestroy() 실행");
		}
	%>
	
	<%!
		// int age = 23; 멤버 중첩
		int[] arr = {11, 22, 33, 44, 55};
	%>
	
	<%
		// scriptlet :: _jspService()
		System.out.println("scriptlet 실행: " + age);
		int age = 23;	// 지역 변수
		System.out.println("scriptlet 실행: " + age);
		// int age = 17;
		String str = "아기상어";
		
		/* 메소드 정의 불가 --> scriptlet은 _jspService()인 method, method 중첩 정의 X
		void meth_2() {
			System.out.println("meth_1() 실행");
		}*/
		
		out.println("str: " + str);
	%>
</body>
</html>