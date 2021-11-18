<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>

<body align="center">
	<h1>글 상세</h1>
	<h3><a href="logout.do">Log-out</a></h3>
	<hr>

	<div  align="center">
	<form action="updateBoard.do" method="get">
		<input type="hidden" name="seq" value="${board.seq }">
		<table border="1" cellpadding="0"  cellspacing="0">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title" value="${board.title }"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">작성자</td>
				<td align="left">${board.writer }</td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">내용</td>
				<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">등록일</td>
				<td align="left">${board.regDate }</td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">조회수</td>
				<td align="left">${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글 수정" />
				</td>
			</tr>
		</table>
	</form>
	</div>	
		
	<hr>
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>			
</body>
</html>