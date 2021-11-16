<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.spring.study.impl.StudyDAO" %>
<%@ page import="com.encore.spring.study.StudyVO" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학습 목록</title>
</head>
<body>
	<h1>스프링 작심 5일</h1>
	<hr />
	<div align="center">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th width="150">학습일자</th>
				<th width="300">학습 내용</th>
				<th width="100">학습량</th>
			</tr>
			<c:forEach items="${studyList}" var="study">
			<tr>
				<td width="150">${study.studyDate}</td>
				<td width="300">
					<a href="getStudy.do?seq=${study.seq}">
						${study.subject}
					</a>
				</td>
				<td width="100">${study.volume}</td>
			</tr>
			</c:forEach>
		</table>
	</div><br />
	<a href="insertStudy.jsp">학습 추가</a>
</body>
</html>