<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분류별 과목 점수 데이터</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" 
crossorigin="anonymous"></script>
<script type="text/javascript">
	function categoriesChange(){
		let form = document.dataSet;
		form.action="?";
		form.submit();
	}
</script>
</head>
<body>
	<div class="container my-3">
		<h2>분류별 과목 점수 데이터</h2>
		<form action="" name="dataSet">
			<!-- 정렬을 위한 카테고리 선택시 재요청된 카테고리 배열 -->
			<c:forEach var="category" items="${ category }">
				<input type="hidden" value="${ category }" name="sel"></c:forEach>
			<!-- 정렬을 위한 카테고리 선택시 재요청된 정렬 배열 -->
			<c:forEach var="category" items="${ newCategories }">
				<input type="hidden" value="${ category }" name="newCategories"></c:forEach>
			<table class="table table-striped">
				<thead>
					<tr>
						<td align="left">
							<c:forEach var="sel" items="${ category }" ><h4>분류: ${ sel }</h4></c:forEach>
						</td>
						<td colspan="${ fn:length(newDistinct) + 1 }" align="right">
							<select name="selDis" onchange="categoriesChange()">
								<c:forEach items="${ newCategories }" var="category">
									<option <c:if test="${ category eq selDis }">selected</c:if>>${ category }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<!-- 해당 카테고리의 과목 수에 따라 달라질 제목 수와 값 -->
						<c:forEach var="dis" items="${ newDistinct }">
							<td><input type="hidden" value="${ dis }" name="newDistinct">${ dis }</td>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<!-- 결과 출력 -->
					<c:forEach var="res" items="${ results }">
						<c:forEach var="re" items="${ res }">
							<tr>
								<td><input type="hidden" value="${ re.name }" name="name">${ re.name }</td>
								<c:forEach var="score" items="${ re.subjects }">
									<td><input type="hidden" value="${ score }" name="subjects">${ score }</td>
								</c:forEach>
								<td>${ re.sum }</td>
								<td><fmt:formatNumber value="${re.avg}" pattern="#0.00" /></td>
								<td>${ re.rank }</td>
								<td>${ re.grade }</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>