<%@page import="model_p.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	PageData pd = (PageData)request.getAttribute("pd");
%>
<form action="BreplyReg" method="post">
	<input type="hidden" name="gid" value="${ mainData.gid }">
	<input type="hidden" name="seq" value="${ mainData.seq }">
	<input type="hidden" name="lev" value="${ mainData.lev }">
	<input type="hidden" name="page" value="<%= pd.page %>">
	<table border="">
		<tr>
			<td width="100px">제목</td>
			<td width="800px"><input type="text" name="title" style="width: 99%;" value="[Re]${ mainData.title }" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="30" rows="10" name="content" style="resize: none; width: 99%;">[Re]${ mainData.content }</textarea></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성하기" />
				<input type="reset" value="초기화" />
				<a href="BDetail?id=${ mainData.id }&page=${ param.page }">뒤로</a>
			</td>
		</tr>
	</table>
</form>