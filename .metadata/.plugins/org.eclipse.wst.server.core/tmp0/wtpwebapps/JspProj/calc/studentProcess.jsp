<%@page import="java.util.Comparator"%>
<%@page import="java.util.Arrays"%>
<%@page import="basic_P.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String majName = "기본";
	if(request.getParameter("majName") != null){
		majName = request.getParameter("majName");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 점수 계산</title>
<script type="text/javascript">
	function rankChange(){
		let form = document.qwer;
		form.action="?";
		form.submit();
	}
</script>
</head>
<body>
	<%
		String[] stds = request.getParameterValues("std");
		String[] kors = request.getParameterValues("kor");
		String[] engs = request.getParameterValues("eng");
		String[] maths = request.getParameterValues("math");
		
		ArrayList<Person> students = new ArrayList<>();
		
		for(int i=0; i<stds.length; i++){
			Person std = new Person(stds[i], kors[i], engs[i], maths[i]);
			students.add(std);
		}
	%>
	<form action="" name="qwer">
		<table border="">
			<thead>
				<tr>
					<td colspan="7" align="right">
						정렬:
						<select name="majName" id="" onchange="rankChange()">
							<% 
								String[] maj = {"기본", "평균"};
								for (int i=0; i<maj.length; i++) {
									String sel = "";
									
									if(maj[i].equals(majName)){
										sel = "selected";
									}
							%>
								<option <%= sel %> ><%= maj[i] %></option>
							<% } %>
						</select>
					</td>
				</tr>
				<tr>
					<td>이름</td><td>국어</td><td>영어</td><td>수학</td><td>총점</td><td>평균</td><td>등수</td>
				</tr>
			</thead>
			<tbody>
				<%
					if(majName.equals("기본")) {
					
						for (int i=0; i<students.size(); i++) {
							int count = 1;
							for(int j=0; j<students.size(); j++){
								if(students.get(i).getAvg() < students.get(j).getAvg()){
									count++;									
								}
							}
							
							students.get(i).setRank(count);
						}
						
						for(int i=1; i<=students.size(); i++){
							for(Person std : students){
								if(std.getRank() == i){
				%>
					<tr>
						<td><%= std.getName() %></td>
						<td><%= std.getKor() %></td>
						<td><%= std.getEng() %></td>
						<td><%= std.getMath() %></td>
						<td><%= std.getSum() %></td>
						<td><%= std.getAvg() %></td>
						<td><%= std.getRank() %></td>
					</tr>
				<% 				}
							}
						}
					}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>