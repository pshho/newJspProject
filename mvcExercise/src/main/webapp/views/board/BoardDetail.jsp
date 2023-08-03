<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="" style="width: 800px;">
	<thead align="center">
		<tr>
			<td>번호</td><td>${ bA.id }</td>
		</tr>
		<tr>
			<td>제목</td><td>${ bA.title }</td>
		</tr>
		<tr>
			<td>작성자</td><td>${ bA.wname }</td>
		</tr>
		<tr>
			<td>작성일</td><td>${ bA.reg_date }</td>
		</tr>
		<tr>
			<td>조회수</td><td>${ bA.cnt }</td>
		</tr>
	</thead>
	<tbody align="center">
		<tr>
			<td colspan="2" align="right"><a href="BoardList">목록으로</a></td>
		</tr>
	</tbody>
</table>