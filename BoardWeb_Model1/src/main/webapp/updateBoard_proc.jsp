<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.biz.board.impl.BoardDAO"%>
<%@ page import="com.encore.biz.board.BoardVO"%>
<%-- getBoard.jsp에서 수정된 값을 전송받아 처리(Controller) --%>
<%	
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String seq = request.getParameter("seq");
	// "seq"는 사용자 화면에서는 보이지 않도록 type="hidden"으로 설정했음
	
	// 2. DB 연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	vo.setTitle(title);
	vo.setContent(content);
	
	BoardDAO dao = new BoardDAO();
	dao.updateBoard(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>