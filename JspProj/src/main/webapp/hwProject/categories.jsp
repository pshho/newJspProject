<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 랜덤 점수 데이터 생성자 -->
<%! Random rd = new Random(); %>
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
		let sel = form.sel.value;
		form.action="?";
		if(sel != '분류'){
			form.submit();
		}
	}
	
	function namesInput(){
		let form = document.dataSet;
		form.action="?";
		form.submit();
	}
</script>
</head>
<body>
	<div class="container my-3">
		<h2>분류별 과목 점수 데이터</h2>
		<form action="/JspProj/hwProject/categoriesProcess" name="dataSet">
			<input type="hidden" name="selDis" value="등수"> <!-- 결과 출력 페이지에서 보일 정렬의 기본값 -->
			<table class="table table-striped">
				<thead>
					<tr>
						<!-- 학생 수 입력 받는 열 -->
						<td style="width: 350px;">
							<label for="namesCount">학생수 입력: </label>
							<input type="number" name="namesCount" value="${ nameCount }">
							<input type="submit" value="입력" onclick="namesInput()">
						</td>
						<!-- 카테고리 선택 -->
						<td colspan="${ fn:length(distinct) }" align="right">
							<select name="sel" onchange="categoriesChange()">
								<!-- 카테고리 목록 배열로 자신의 선택을 알게 함 -->
								<c:forEach items="${ categories }" var="category">
									<option <c:if test="${ category eq sel }" >selected</c:if>>${ category }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<!-- 해당 카테고리의 과목 수에 따라 달라질 제목 수와 값 -->
						<c:forEach var="dis" items="${ distinct }">
							<td><input type="hidden" value="${ dis }" name="distinct">${ dis }</td>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<!-- 이름 데이터 입력받기 위한 for문으로 학생수만큼 행 생성 -->
					<c:forEach begin="1" end="${ fn:length(names) }">
						<tr>
							<td <c:if test="${ distinct eq null }">colspan="2"</c:if>>
								<input type="text" name="name" style="width: 120px;">
							</td>
							<!-- 해당 카테고리만큼 과목 수에 따라 랜덤 점수 데이터 열 생성 및 대입 -->
							<c:forEach var="dis" items="${ distinct }">
								<td><input type="text" name="subjects" 
									value="<%= rd.nextInt(50, 100) %>" style="width: 50%;"></td>
							</c:forEach>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="${ fn:length(distinct) + 2 }" align="right">
							<input type="submit" value="제출" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>