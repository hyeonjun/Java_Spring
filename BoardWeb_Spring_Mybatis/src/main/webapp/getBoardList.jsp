<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>

<body align="center">
	<h1><spring:message code="message.board.list.mainTitle"></spring:message></h1>
	<h3>${userName } <spring:message code="message.board.list.welcomeMsg"></spring:message>.. <a href="logout.do">Log-out</a></h3>
	<!-- <h3>테스트님 환영합니다.<a href="logout.do">Log-out</a></h3> -->
	
	<!-- 검색 시작 -->
	<div align="center">
	<form action="getBoardList.do" method="post">
		<table border="1" cellpadding="0"  cellspacing="0" width="700">
			<tr>
				<td align="right">
				<!-- BoardController 의  @ModelAttribute : 검색 조건 목록 설정 --> 
					<select name="searchCondition">
						<c:forEach items="${contitionMap }" var="option">
							<option value="${option.value }">${option.key }
						</c:forEach>
					</select>
					
					<!-- 기존 검색 
					<select name="searchCondition">
						<option value="TITLE">제목</option>
						<option value="CONTENT">내용</option>
					</select>
					 -->
					<input type="text" name="searchKeyword" />
					<input type="submit" value="<spring:message code="message.board.list.search.condition.btn"></spring:message>">
				</td>
			</tr>
		</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1" cellpadding="0"  cellspacing="0" width="700" >
		<tr>
			<th bgcolor="orange" width="100" ><spring:message code="message.board.list.table.head.seq"></spring:message></th>
			<th bgcolor="orange" width="200"><spring:message code="message.board.list.table.head.title"></spring:message></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.writer"></spring:message></th>
			<th bgcolor="orange" width="150"><spring:message code="message.board.list.table.head.regDate"></spring:message></th>
			<th bgcolor="orange" width="100"><spring:message code="message.board.list.table.head.cnt"></spring:message></th>
		</tr>
		
		<c:forEach items="${boardList }" var="board">
		<tr>
			<td align="center">${board.seq }</td>
			<td align="left">&nbsp;&nbsp;<a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
			<td align="center">${board.writer }</td>
			
<%-- 		<td align="center">${board.regDate }</td> --%>

			<td align="center"><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd"/></td>
			<td align="center">${board.cnt }</td>
		</tr>	
		</c:forEach>

	</table>
	
	</div>	
	<br />
	<a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"></spring:message></a>
</body>
</html>