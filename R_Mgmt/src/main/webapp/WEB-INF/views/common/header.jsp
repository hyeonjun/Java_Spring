<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<header
		class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
		<a href="/home/resume"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
			<span class="fs-4"><strong>RMGMT</strong></span>
		</a>

		<ul class="nav nav-pills">
			<li class="nav-item"><a href="/home/resume" class="nav-link active"
				aria-current="page">Home</a></li>
			<% 
        		String userid = (String) session.getAttribute("user");
				if (userid == null){
			%>
				<li class="nav-item"><a href="/home/login" class="nav-link">로그인</a></li>
				<li class="nav-item"><a href="/home/signUp" class="nav-link">회원가입</a></li>
			<% } else { %>
				<li class="nav-item"><a href="#" class="nav-link"><%=userid %>님 </a></li>
				<li class="nav-item"><a href="/jquery/logout" class="nav-link">로그아웃</a></li>
			<% }  %>
		</ul>
	</header>
</div>
