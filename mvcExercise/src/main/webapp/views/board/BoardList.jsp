<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="" style="width: 800px;">
	<thead align="center">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach items="${ list }" var="li">
			<tr>
				<td>${ li.id }</td>
				<td><a href="BoardDetail?id=${ li.id }">${ li.title }</a></td>
				<td>${ li.wname }</td>
				<td>${ li.reg_date }</td>
				<td>${ li.cnt }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right"><a href="">글쓰기</a></td>
		</tr>
	</tbody>
</table>