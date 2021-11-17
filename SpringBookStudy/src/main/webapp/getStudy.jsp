<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세보기 화면</title>
</head>
<body>
	<h1>상세보기</h1>
	<table>
		<tr>
			<td>${study.seq }</td>
			<td>${study.category }</td>
			<td>${study.title }</td>
			<td>${study.content }</td>
			<td>${study.studyDate }</td>
			<td>${study.cnt }</td>
		</tr>
	</table>
	<a href="updateStudy.do?seq=${study.seq}">수정화면 이동</a>
	<a href="deleteStudy.do?seq=${study.seq}">삭제처리</a>
	<a href="getStudyList.do">목록 화면 이동</a>
</body>
</html>