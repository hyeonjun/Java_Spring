<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학습 목록</title>
	<script>
		function insertURL(){
			document.location.href="insertStudy.do";
		}
	</script>
</head>
<!-- studyList -->
<body>
	<h1>목록 화면</h1>
	
	<table>
		<tr>
			<th>학습일</th><th>학습내용</th><th>학습량</th>
		</tr>
		<c:forEach items="${studyList}" var="study">
			<tr>
				<td>${study.category}</td>
				<td>
					<a href="getStudy.do?seq=${study.seq}">${study.title}</a>
				</td>
				<td>${study.cnt} chapter</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<input type="button" value="등록화면 이동" onclick="insertURL()"/>
</body>
</html>