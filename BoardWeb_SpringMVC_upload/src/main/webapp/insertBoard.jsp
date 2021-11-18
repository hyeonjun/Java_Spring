<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUTF-8">
<title>글 상세</title>
</head>

<body align="center">
	<h1>글 등록</h1>
	<h3><a href="logout.do">Log-out</a></h3>
	<hr>
	
	<div align="center">
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0"  cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title" required="required"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">작성자</td>
				<td align="left"><input type="text" name="writer" required="required"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
			</tr>
			<!-- File Upload -->
			<tr>
				<td>
					<input type="file" name="uploadFile"  />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="새글 등록" />
				</td>
			</tr>
		</table>
	</form>
	</div>
			
	<hr>
	<a href="getBoardList.do">글 목록 가기</a>			
</body>
</html>