<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.biz.board.impl.BoardDAO" %>
<%@ page import="com.encore.biz.board.BoardVO" %>
<%@ page import="java.util.List" %>
<%-- 로그인 성공 시 게시판 목록 출력하는 파일 (Controller / View) 기능 --%>
<% 
	List<BoardVO> boardList = (List<BoardVO>) session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<h3>~~ 님 환영합니다. <a href="logout.do">로그아웃</a></h3>
	<!-- 검색 목록 출력 -->
	<div align="center">
		<!-- 검색어 입력창 시작 -->
		<form action="getBoardList.do" method="post">
			<table>
				<tr>
					<td>
						<select name="searchCondition">
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
						</select>
						<input type="text" name="searchKeyword" />
						<input type="submit" value="검색어를 입력하세요."/>
					</td>
				</tr>
			</table>
		</form>
		<!-- 검색어 입력창 끝 -->	
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th width="100">번호</th>
				<th width="200">제목</th>
				<th width="150">작성자</th>
				<th width="150">등록일</th>
				<th width="100">조회수</th>
			</tr>
			<% for(BoardVO board : boardList) {%>
			<tr>
				<td width="100"><%= board.getSeq() %></td>
				<td width="200">
					<a href="getBoard.do?seq=<%= board.getSeq() %>">
						<%= board.getTitle() %>
					</a>
				</td>
				<td width="150"><%= board.getWriter() %></td>
				<td width="150"><%= board.getRegDate() %></td>
				<td width="100"><%= board.getCnt() %></td>
			</tr>
			<% } %>
		</table>
	</div>
	<!-- 검색 결과 끝 -->
	<br />
	<a href="insertBoard.jsp">새 글 등록</a>
</body>
</html>