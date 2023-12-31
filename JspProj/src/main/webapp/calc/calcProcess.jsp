<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>짝수</title>
</head>
<body>
	<h2>짝수 모음</h2>
	<c:set var="cal" value="${ paramValues.calc }"></c:set>
	<c:set var="sum" value="0"></c:set>
	<c:set var="count" value="0"></c:set>
	<c:set var="max" value="0"></c:set>
	<c:set var="min" value="0"></c:set>
	<c:set var="avg" value="0"></c:set>
	<c:forEach items="${ cal }" var="ca">
		<c:if test="${ ca%2 == 0 and ca != 0 }">
			<c:set var="sum" value="${ sum + ca }"></c:set>
			
			<c:if test="${ max == 0 and min == 0 }">
				<c:set var="max" value="${ ca }"></c:set>
				<c:set var="min" value="${ ca }"></c:set>
			</c:if>
			<%-- <c:out value="${ ca }"></c:out> --%>
		</c:if>
	</c:forEach>
	<c:out value="합계 : ${ sum }"></c:out>
</body>
</html>