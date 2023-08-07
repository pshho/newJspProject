<%@page import="model_p.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PageData pd = (PageData)request.getAttribute("pd");
%>
<form action="BdeleteReg" method="post">
	<input type="hidden" name="id" value="${ param.id }">
	<input type="hidden" name="page" value="<%= pd.page %>">
	<table border="">
		<tr>
			<td width="100px">암호</td>
			<td width="800px"><input type="text" name="pw" style="width: 99%;" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="삭제" />
				<a href="BDetail?id=${ param.id }&page=${ param.page }">뒤로</a>
			</td>
		</tr>
	</table>
</form>