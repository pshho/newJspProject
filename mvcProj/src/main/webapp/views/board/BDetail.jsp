<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table border="">
	<tbody>
		<tr>
			<td width="200px">번호</td><td width="700px">${ mainData.id }</td>
		</tr>
		<tr>
			<td>제목</td><td>${ mainData.title }</td>
		</tr>
		<tr>
			<td>작성자</td><td>${ mainData.pname }</td>
		</tr>
		<tr>
			<td>작성일</td><td>${ mainData.reg_date }</td>
		</tr>
		<tr>
			<td>조회수</td><td>${ mainData.cnt }</td>
		</tr>
		<tr>
			<td>내용</td><td>${ mainData.content }</td>
		</tr>
		<tr>
			<td>파일</td><td>${ mainData.upfile }</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a href="BList">목록으로</a>
			</td>
		</tr>
	</tbody>
</table>