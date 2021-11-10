<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.rmgmt.Service.IntroduceVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/common.jsp" %>
<% if((String) session.getAttribute("user") == null){
		response.sendRedirect("/home/login");
	} 
%>
	<script>
		var project_P;
		var project_T;
		function init(){
			project_P = document.querySelector("#tbl_Pdiv");
			project_T = document.querySelector("#tbl_Tdiv");
			Intro();
			ProjectP();
			ProjectT();
		}
		
		function Intro(){
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
					$('#content').html(data.writing+"<br />");
				}
			});
		}
		
		function ProjectP(){
			console.log("P");
			$.ajax({
				type:"GET",
				url:"/jquery/projectList",
				data:{
					seq : '<%= session.getAttribute("seq") %>',
					role : 1
				},
				success:function(data){
					/* <tr>
					<th>Name. </th> Phone.
					<th id="name"></th>
					</tr> */
					var tag = "";
					for (var i=0; i<data.length; i++){
						tag += "<table>"
						tag += "<tr><th colspan='2'><h3>"+data[i].title+"</h3></th></tr>";
						tag += "<tr><th>진행 기간 : </th>";
						tag += "<th>"+data[i].startDate+" - "+data[i].endDate+"</th></tr>";
						tag += "<tr><th>주요 내용 : </th>";
						tag += "<th>"+data[i].content+"</th></tr>";
						tag += "<tr><th>사용한 Skill 또는 지식 : </th>";
						tag += "<th>"+data[i].skill+"</th></tr>";
						tag += "<tr><th>경험했던 이슈와 해결 방법 : </th>";
						tag += "<th>"+data[i].issue+"</th></tr>";
						tag += "<tr><th>결과/성과 : </th>";
						tag += "<th>"+data[i].result+"</th></tr>";
						tag += "<tr><th>Github/Blog : </th>";
						tag += "<th>"+data[i].github+"</th></tr>";
						tag += "</table><div style='float:right'>";
						tag += "<a id='projectTupdate' style='margin-right:5px;' href='/portfolio/update?pSeq="+data[i].pSeq+"'>";
						tag += "<label style='cursor:pointer; text-decoration:underline; text-underline-position:under;'>수정</label></a>";
						tag += "<a id='projectTdelete' href='javascript:ProjectDelete("+data[i].pSeq+");'>";
						tag += "<label style='cursor:pointer; text-decoration:underline; text-underline-position:under;'>삭제</label></a></div>";
					}
					project_P.innerHTML = tag;
				}
			});
		}
		
		function ProjectT(){
			console.log("T");
			$.ajax({
				type:"GET",
				url:"/jquery/projectList",
				data:{
					seq : '<%= session.getAttribute("seq") %>',
					role : 2
				},
				success:function(data){
					console.log(data);
					// input hidden -> data.pSeq
					var tag = "";
					for (var i=0; i<data.length; i++){
						tag += "<table>"
						tag += "<tr><th colspan='2'><h3>"+data[i].title+"</h3></th></tr>";
						tag += "<tr><th>진행 기간 : </th>";
						tag += "<th>"+data[i].startDate+" - "+data[i].endDate+"</th></tr>";
						tag += "<tr><th>주요 내용 : </th>";
						tag += "<th>"+data[i].content+"</th></tr>";
						tag += "<tr><th>사용한 Skill 또는 지식 : </th>";
						tag += "<th>"+data[i].skill+"</th></tr>";
						tag += "<tr><th>경험했던 이슈와 해결 방법 : </th>";
						tag += "<th>"+data[i].issue+"</th></tr>";
						tag += "<tr><th>결과/성과 : </th>";
						tag += "<th>"+data[i].result+"</th></tr>";
						tag += "<tr><th>Github/Blog : </th>";
						tag += "<th>"+data[i].github+"</th></tr>";
						tag += "</table><div style='float:right'>";
						tag += "<a id='projectTupdate' style='margin-right:5px;' href='/portfolio/update?pSeq="+data[i].pSeq+"'>";
						tag += "<label style='cursor:pointer; text-decoration:underline; text-underline-position:under;'>수정</label></a>";
						tag += "<a id='projectTdelete' href='javascript:ProjectDelete("+data[i].pSeq+");'>";
						tag += "<label style='cursor:pointer; text-decoration:underline; text-underline-position:under;'>삭제</label></a></div>";
					}
					project_T.innerHTML = tag;
				}
			});
		}
		
		function ProjectDelete(pSeq){
			console.log(pSeq);
			/* "/jquery/projectDelete?pSeq="+pSeq */
		}
	</script>
	<style>
		body {
			margin:0 auto;
			width:1000px;
		}
		
		#intro {
			margin-bottom:20px;
		}
		
		#introduce {
			border-collapse: collapse;
			border-spacing: 10px;
			align: center;
		}
		
		#title {
			text-align:left;
			margin-bottom:20px;
		}
		
		#introUpdate {
			float:right;
		}
		
		#content {
			font-size:1rem;
		}
		
	</style>
	
</head>
<body onload="init()">
	<%@ include file="../common/header.jsp" %>
	<div id="intro">
		<div>
			<h1 id="title"></h1>
			<table id="introduce" border="1">
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
				<tr><th><br/></th></tr>
				<tr>
					<th colspan="2"><h2>Introduce.</h2></th>
				</tr>
				<tr>
					<th colspan="2" id="content"></th>
				</tr>
			</table>
		</div>
		<a id="introUpdate" href="/introduce/write"><label style="cursor:pointer; text-decoration:underline; text-underline-position:under;">수정</label></a>
	</div>
	<br /><hr />
	<div id="project_p">
		<h1 id="title">개인 프로젝트</h1>
		<a id="projectPinsert" href="/portfolio/insert?role=1"><label style="cursor:pointer; text-decoration:underline; text-underline-position:under;">추가</label></a>
		<div id="tbl_Pdiv"></div>
	</div>
	<br /><hr />
	<div id="project_t">
		<h1 id="title">팀 프로젝트</h1>
		<a id="projectTinsert" href="/portfolio/insert?role=2"><label style="cursor:pointer; text-decoration:underline; text-underline-position:under;">추가</label></a>
		<div id="tbl_Tdiv"></div>
	</div>
</body>
</html>