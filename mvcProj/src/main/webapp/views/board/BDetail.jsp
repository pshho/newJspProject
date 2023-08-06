<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<td>내용</td><td>${ mainData.BContent }</td>
		</tr>
		<c:if test="${ mainData.upfile ne '' }">
			<tr>
				<td>파일</td>
				<c:choose>
					<c:when test="${ mainData.isImg }">
						<td><img alt="" src="/mvcProj/up/${ mainData.upfile }" width="500px"></td>
					</c:when>
					<c:otherwise><td><a href="/mvcProj/nonJsp/FileDown?fName=${ mainData.upfile }">${ mainData.upfile }</a></td></c:otherwise>
				</c:choose>
			</tr>
		</c:if>
		<tr>
			<td colspan="2" align="right">
				<a href="BreplyForm?id=${ mainData.id }">답변</a>
				<a href="BmodifyForm?id=${ mainData.id }">수정</a>
				<a href="BdeleteForm?id=${ mainData.id }">삭제</a>
				<a href="BList">목록으로</a>
			</td>
		</tr>
	</tbody>
</table>