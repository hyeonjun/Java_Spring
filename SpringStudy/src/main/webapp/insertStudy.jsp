<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학습 추가</title>
</head>
<body>
	<h1>스프링 학습 추가</h1>
	<hr />
	<div align="center">
		<form action="insertStudy.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>학습 주제</td>
					<td><input type="text" name="subject" required="required"></td>
				</tr>
				<tr>
					<td>학습일자</td>
					<td><input type="text" name="studyDate" required="required"></td>
				</tr>
				<tr>
					<td>학습 세부내용</td>
					<td><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>	
					<td>학습량</td>
					<td><input type="number" name="volume" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="학습 추가"></td>
					<td><input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
	<hr>
	<a href="getStudyList.do">학습 목록</a>
</body>
</html>