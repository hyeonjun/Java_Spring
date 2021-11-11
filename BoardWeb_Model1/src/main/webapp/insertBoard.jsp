<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 새로운 글 등록 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 등록</title>
</head>
<body>
	<h1>글 등록</h1>
	<hr />
	<div align="center">
		<form action="insertBoard_proc.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" required="required" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" required="required" /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" cols="40" rows="10" required="required" ></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="글 등록" /></td>
					<td><input type="reset" value="취소" /></td>
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<a href="getBoardList.jsp">글 목록</a>
</body>
</html>