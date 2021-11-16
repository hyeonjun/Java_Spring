<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.biz.board.impl.BoardDAO" %>
<%@ page import="com.encore.biz.board.BoardVO" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 상세</title>
</head>
<body>
	<h1>글 상세보기</h1>
	<hr />
	
	<div align="center">
		<form action="updateBoard.do" method="post">
			<!-- "hidden" : 사용자 화면에서 보이지 않고 값을 전송 -->
			<input type="hidden" name="seq" value="${board.seq}"/>
			
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${board.title}" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>${board.regDate}</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글 수정" /><input type="reset" value="취소" /></td>
					<!-- <td></td> -->
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<a href="insertBoard.jsp">새 글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>
</body>
</html>