<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="">
	<tbody align="center">
		<tr>
			<td width="50px">번호</td>
			<td width="500px">제목</td>
			<td width="100px">작성자</td>
			<td width="200px">작성일</td>
			<td width="50px">조회수</td>
		</tr>
		<c:forEach items="${ mainData }" var="data">
			<tr align="center">
				<td>${ data.id }</td>
				<td><a href="BDetail?id=${ data.id }">${ data.title }</a></td>
				<td>${ data.pname }</td>
				<td>${ data.reg_date }</td>
				<td>${ data.cnt }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center"></td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<a href="BwriteForm">글쓰기</a>
			</td>
		</tr>
	</tbody>
</table>