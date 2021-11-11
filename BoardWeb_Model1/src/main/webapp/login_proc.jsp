<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 이 파일은 Controller 역할을 수행 --%>

<%-- Model 역할을 하는 VO, DAO 클래스 --%>
<%@ page import="com.encore.biz.user.impl.UserDAO" %>
<%@ page import="com.encore.biz.user.UserVO" %>

<%
	// 1. 사용자가 입력한 데이터(정보) 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB 연동
	UserVO vo= new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserVO user = dao.getUser(vo);
	
	// 3.결과에 따른 화면 내비게이션(화면 분기)
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}
%>