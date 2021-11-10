<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>포트폴리오 관리</title>
</head>
<body>
	<% if(session.getAttribute("user") == null){
			response.sendRedirect("/home/login");
		} else{
			response.sendRedirect("/introduce/write");
		}
	%>


</body>
</html>