<%@page import="model_p.GalleryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	ArrayList<GalleryDTO> ar = (ArrayList<GalleryDTO>) request.getAttribute("mainData");
%>
<style>
	ul {
		padding-left: 0;
	}
	ul li{
		list-style: none;
		border-bottom: 1px solid #ccc;
		margin: 5px auto;
	}
</style>
<table border="" style="width: 1200px;">
	<tbody align="center">
		<c:forEach begin="1" end="2" varStatus="i">
			<tr>
				<c:forEach items="${ mainData }" var="gal" varStatus="j" begin="0">
					<c:if test="${ (i.index - 1) * 5 <= j.index && i.index * 5 > j.index }">
						<td>
							<ul>
								<li>번호: ${ gal.id }</li>
								<li>조회수: ${ gal.cnt }</li>
								<li>제목: ${ gal.title }</li>
								<li>작성자: ${ gal.pname }</li>
								<li><a href="GalleryDetail?id=${ gal.id }"><img width="200px" height="200px" alt="사진" src="/mvcProj/galUp/${ gal.upfile }"></a></li>
								<li>설명: ${ gal.descriptions }</li>
								<li>작성일: ${ gal.RReg_date }</li>
							</ul>
						</td>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"></td>
		</tr>
		<tr>
			<td colspan="5" align="right"><a href="GalleryWrite">글작성</a></td>
		</tr>
	</tbody>
</table>