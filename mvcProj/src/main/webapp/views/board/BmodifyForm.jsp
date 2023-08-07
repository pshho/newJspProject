<%@page import="model_p.PageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	PageData pd = (PageData)request.getAttribute("pd");
%>
<script type="text/javascript">
	function fileDel(){
		alert("파일을 정말 삭제하시겠습니까?");
		modifyF.action="BFileDelete?page=<%= pd.page %>";
		modifyF.submit();
	}
</script>
<form action="BmodifyReg?page=${ param.page }" method="post" enctype="multipart/form-data" name="modifyF">
	<table border="">
		<tr>
			<td width="100px">번호</td>
			<td width="800px"><input type="text" name="id" style="width: 99%;" value="${ mainData.id }" readonly /></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" style="width: 99%;" value="${ mainData.title }" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" style="width: 99%;" value="${ mainData.pname }" /></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${ mainData.reg_date }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea cols="30" rows="10" name="content" style="resize: none; width: 99%;">${ mainData.content }</textarea></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" style="width: 99%;" /></td>
		</tr>
		<c:if test="${ mainData.seq eq 0 }">
			<tr>
				<td>파일</td>
				<td>
					<c:choose>
						<c:when test="${ mainData.upfile eq '' }">
							<input type="file" name="upfile" style="width: 99%;" />
						</c:when>
						<c:otherwise>
							${ mainData.upfile }<input type="button" value="파일삭제" onclick="fileDel()">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기" />
				<input type="reset" value="초기화" />
				<a href="BDetail?id=${ mainData.id }&page=${ param.page }">뒤로</a>
			</td>
		</tr>
	</table>
</form>