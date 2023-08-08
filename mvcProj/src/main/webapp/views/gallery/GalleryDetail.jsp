<%@page import="model_p.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	PageData pd = (PageData)request.getAttribute("pd");
%>
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
			<td>작성일</td><td>${ mainData.RReg_date }</td>
		</tr>
		<tr>
			<td>조회수</td><td>${ mainData.cnt }</td>
		</tr>
		<tr>
			<td>내용</td><td>${ mainData.descriptions }</td>
		</tr>
		<tr>
			<td>사진</td>
			<td><img alt="" src="/mvcProj/galUp/${ mainData.upfile }" width="500px"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<a href="GalleryModify?id=${ mainData.id }">수정</a>
				<a href="GalleryDelete?id=${ mainData.id }">삭제</a>
				<a href="GalleryList">목록으로</a>
			</td>
		</tr>
	</tbody>
</table>