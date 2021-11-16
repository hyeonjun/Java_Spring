<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.spring.study.impl.StudyDAO" %>
<%@ page import="com.encore.spring.study.StudyVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학습 상세보기</title>
</head>
<body>
	<h1>${study.studyDate} : ${study.subject} </h1>
	<hr />
	<div align="center">
		<form action="updateStudy.do" method="post">
			<input type="hidden" name="seq" value="${study.seq}"/>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>학습 주제</td>
					<td><input type="text" name="subject" value="${study.subject }" /></td>
				</tr>
				<tr>
					<td>학습 세부내용</td>
					<td><textarea name="content" cols="40" rows="10">${study.content }</textarea></td>
				</tr>
				<tr>	
					<td>학습량</td>
					<td><input type="text" name="volume" value="${study.volume }" />chapter</td>
				</tr>
				<tr>
					<td><input type="submit" value="학습 수정" /></td>
					<td><input type="reset" value="취소" /></td>
				</tr>
			</table>
		</form>
	</div>
	<a href="insertStudy.jsp">학습 추가</a>
	<a href="deleteStudy.do?seq=${study.seq}">학습 삭제</a>
	<a href="getStudyList.do">학습 목록</a>
</body>
</html>