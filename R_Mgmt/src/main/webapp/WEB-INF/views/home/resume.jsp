<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.rmgmt.Service.IntroduceVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/common.jsp" %>
<% if((String) session.getAttribute("user") == null){
		response.sendRedirect("/home/login");
	} 
%>
	<script>
		function init(){
			$.ajax({
				type:"GET",
				url:"/jquery/introGet",
				data:{
					seq : '<%= session.getAttribute("seq") %>'
				},
				success:function(data){
					$('#title').html(data.title);
					$('#name').html(data.name);
					$('#phone').html(data.phone);
					$('#email').html(data.email);
					$('#github').html(data.github);
					$('#blog').html(data.blog);
					$('#content').html(data.writing);
				}
			});
			
			
		}
	</script>
	<style>
		#introduce {
			border-collapse: collapse;
			border-spacing: 10px;
			align: center;
		}
	</style>
</head>
<body onload="init()">
	<%@ include file="../common/header.jsp" %>
	<div id="intro" align="center">
		<h1 id="title"></h1>
		<table id="introduce">
			<tr>
				<th>Name. </th>
				<th id="name"></th>
			</tr>
			<tr>
				<th>Phone. </th>
				<th id="phone"></th>
			</tr>
			<tr>
				<th>E-Mail. </th>
				<th id="email"></th>
			</tr>
			<tr>
				<th>GitHub. </th>
				<th id="github"></th>
			</tr>
			<tr>
				<th>Blog. </th>
				<th id="blog"></th>
			</tr>
			<tr>
				<th colspan="2" id="content"></th>
			</tr>
		</table>
	</div>
</body>
</html>