<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.biz.board.impl.BoardDAO"%>
<%@ page import="com.encore.biz.board.BoardVO"%>
<% 
	session.invalidate();

	response.sendRedirect("login.jsp");
%>