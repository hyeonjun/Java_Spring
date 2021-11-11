<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<% if((String) session.getAttribute("user") == null){
		response.sendRedirect("/home/login");
	} 
%>

	<script>
		function init(){
			$.ajax({
				type:"GET",
				url:"/jquery/projectGet",
				data:{
					seq: <%= session.getAttribute("seq") %>,
					pSeq: <%= request.getParameter("pSeq") %>
				},
				success:function(data){
					console.log(data);
					$("#title").attr('value',data.title);
					$("#start").attr('value',data.startDate);
					$("#end").attr('value',data.endDate);
					$("#content").html(data.content.replaceAll('<br />', '\n'));
					$("#skill").attr('value',data.skill);
					$("#issue").html(data.issue.replaceAll('<br />', '\n'));
					$("#result").html(data.result.replaceAll('<br />', '\n'));
					$("#path").attr('value',data.github);
				}
			});
		}
		
		function projectSave(){
			$.ajax({
				url:"/jquery/projectUpdate",
				type:"POST",
				data:{
					seq: <%= session.getAttribute("seq") %>,
					pSeq: <%= request.getParameter("pSeq") %>,
					title: $('#title').val(),
					startDate: $('#start').val(),
					endDate: $('#end').val(),
					content: $('#content').val().replaceAll('\n', '<br />'),
					skill: $('#skill').val(),
					issue: $('#issue').val().replaceAll('\n', '<br />'),
					result: $('#result').val().replaceAll('\n', '<br />'),
					github: $('#path').val(),
					pictures: "pictures",
				},
				success:function(data){
					if(!data){
						swal("동록 실패");
					} else {
						swal({
							title: "등록완료",
							text: "메인화면으로 이동합니다.",
							icon:"success",
							closeOnclickOutside:false,
							buttons:{
								confirm:{
									text:"메인 화면으로",
									value:true
								}
							}
						}).then(function(){
							location.href="/home/resume";
						});
					}
				}
			});
		}
	
	</script>
	<style>
		body {
			padding-top: 70px;
			padding-bottom: 30px;
		}
		
		.select_img img {
			margin:20px 0;
		}
	</style>
</head>
<body onload="init()">
<%@ include file="../common/header.jsp" %>
	<article>
		<div class="container" role="main">
			<h2>프로젝트</h2>
			<form name="form" id="form" action="">
				<div class="mb-3">
					<label for="title">Title</label> 
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="start">Progress.</label> 
					<input type="text" class="form-control" name="start" id="start" placeholder="Start Date(2021-11)" style="margin-bottom:10px">
					<input type="text" class="form-control" name="end" id="end" placeholder="End Date(2021-11)">
				</div>
				<div class="mb-3">
					<label for="content">Content.</label> 
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="주요 내용"></textarea>
				</div>
				<div class="mb-3">
					<label for="blog">Skill.</label> 
					<input type="text" class="form-control" name="skill" id="skill" placeholder="사용한 Skill 또는 지식">
				</div>
				<div class="mb-3">
					<label for="issue">Issue.</label>
					<textarea class="form-control" rows="5" name="issue" id="issue" placeholder="경험했던 기술적 이슈와 해결한 방법"></textarea>
				</div>
				<div class="mb-3">
					<label for="result">Result.</label>
					<textarea class="form-control" rows="5" name="result" id="result" placeholder="결과 또는 성과"></textarea>
				</div>
				<div class="mb-3">
					<label for="path">GitHub/Blog.</label>
					<input type="text" class="form-control" name="path" id="path" placeholder="프로젝트 관련 깃허브나 블로그 주소">
				</div>
				<div class="inputArea">
					<label for="image">이미지</label> 
					<input type="file" id="image" name="image" onchange="pictures(this)"/>
					<div class="select_img"> <img id="select_image" src="" /> </div>
					<%-- <%= request.getRealPath("/") %> --%>
				</div>
			</form>
			<div>
				<input type="button" class="btn btn-sm btn-primary" onclick="projectSave()" value="저장"/>
				<input type="button" class="btn btn-sm btn-primary" onclick="javascript:location.href='/home/resume'" value="뒤로"/>
				<!-- <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button> -->
			</div>
		</div>
	</article>

</body>
</html>