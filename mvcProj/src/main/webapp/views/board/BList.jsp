<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<table border="">
	<tbody align="center">
		<tr>
			<td width="50px">번호</td>
			<td width="500px">제목</td>
			<td width="100px">작성자</td>
			<td width="200px">작성일</td>
			<td width="50px">조회수</td>
		</tr>
		<c:forEach items="${ mainData }" var="data" varStatus="i">
			<tr align="center">
				<td>${ pd.start + i.index + 1 }</td>
				<td align="left">
					<c:forEach begin="1" end="${ data.lev }">
						&nbsp;&nbsp;
					</c:forEach>
					<c:if test="${ data.lev > 0 }">
					└
					</c:if>
					<a href="BDetail?id=${ data.id }&page=${ pd.page }">${ data.title }</a>
				</td>
				<td>${ data.pname }</td>
				<td>${ data.reg_date }</td>
				<td>${ data.cnt }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
				<a href="?page=1">[맨앞]</a>
				<c:if test="${ pd.pageStart > 1 }">
					<a href="?page=${ pd.pageStart - 1 }">[이전]</a>
				</c:if>
				<c:forEach begin="${ pd.pageStart }" end="${ pd.pageEnd }" varStatus="i">
					<c:choose>
						<c:when test="${ i.index eq pd.page }">
							<a href="?page=${ i.index }">[${ i.index }]</a>
						</c:when>
						<c:otherwise>
							<a href="?page=${ i.index }">${ i.index }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${ pd.pageEnd < pd.pageTotal }">
					<a href="?page=${ pd.pageEnd + 1 }">[다음]</a>
				</c:if>
				<a href="?page=${ pd.pageTotal }">[맨끝]</a>
			</td>
		</tr>	
		<tr>
			<td colspan="5" align="right">
				<a href="BwriteForm?page=${ pd.page }">글쓰기</a>
			</td>
		</tr>
	</tbody>
</table>