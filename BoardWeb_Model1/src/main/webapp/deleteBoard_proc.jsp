<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.biz.board.impl.BoardDAO"%>
<%@ page import="com.encore.biz.board.BoardVO"%>
<% 
	// 1. seq 파라미터 값 추출
	request.setCharacterEncoding("UTF-8");
	String seq = request.getParameter("seq");
	
	// 2. DB 연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO dao = new BoardDAO();
	dao.deleteBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>