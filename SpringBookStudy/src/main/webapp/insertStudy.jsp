<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학습 등록화면</title>
	<script src="ckeditor/ckeditor.js"></script>
</head>

<body>
	<h1>학습 등록</h1>
	<form action="insertStudy.do" method="post">
		<table>
			<tr>
				<td>학습 일</td> <!-- 첫째 날(Day 1) -->
				<td>
					<input type="text" name="category" placeholder="* 필수 입력" required="required" />
				</td>
			</tr>
			
			<tr>
				<td>학습 주제</td> <!-- CLASS 01 스프링 프레임워크 시작하기 -->
				<td>
					<input type="text" name="title" placeholder="* 필수 입력" required="required" />
				</td>
			</tr>
			
			<tr>
				<td>세부 내용</td> 
				<td>
					<textarea rows="10" cols="100" name="content"></textarea>
					<script>CKEDITOR.replace("content")</script>
				</td>
			</tr>
			
			<tr>
				<td>학습량</td> 
				<td>
					<input type="text" name="cnt" placeholder="* 필수 입력" required="required"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="학습 등록" /></td>
			</tr>
		</table>
	</form>
	<a href="getStudyList.do">목록 화면 이동</a>
</body>
</html>