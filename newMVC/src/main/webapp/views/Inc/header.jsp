<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String mainTitle = request.getAttribute("mainTitle")+""; %>
<table>
	<thead>
		<tr>
			<td colspan="4" width="900px" align="center">
				<h1><%= mainTitle %></h1>
			</td>
		</tr>
		<tr align="center">
			<th><a href="/newMVC/info">회사소개</a></th>
			<th><a href="/newMVC/product">제품</a></th>
			<th><a href="/newMVC/gallery">갤러리</a></th>
			<th><a href="/newMVC/board/BList">게시판</a></th>
		</tr>
	</thead>
</table>