<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>수정 화면</title>
	<script src="ckeditor/ckeditor.js"></script>
</head>
<body>
	<h1>수정화면</h1>
	<form action="updateStudy.do" method="post">
		<input type="hidden" name="seq" value="${study.seq}" />
		<table>
			<tr>
				<td>학습 일</td> <!-- 첫째 날(Day 1) -->
				<td>
					<input type="text" name="category" value="${study.category }" />
				</td>
			</tr>
			
			<tr>
				<td>학습 주제</td> <!-- CLASS 01 스프링 프레임워크 시작하기 -->
				<td>
					<input type="text" name="title" value="${study.title }" />
				</td>
			</tr>
			
			<tr>
				<td>세부 내용</td> 
				<td>
					<textarea rows="10" cols="100" name="content">${study.content }</textarea>
					<script>CKEDITOR.replace("content")</script>
				</td>
			</tr>
			
			<tr>
				<td>학습량</td> 
				<td>
					<input type="text" name="cnt" value="${study.cnt }"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="수정하기" /></td>
			</tr>
		</table>
	</form>
	<a href="getStudyList.do">목록 화면 이동</a>
</body>
</html>