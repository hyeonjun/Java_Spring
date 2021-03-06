<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.encore.rmgmt.Service.IntroduceVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% if((String) session.getAttribute("user") == null){
		response.sendRedirect("/home/login");
	} 
%>
<%@ include file="../common/common.jsp" %>
	<script>
		function init(){
			$.ajax({
				type:"GET",
				url:"/jquery/introGet",
				data:{
					seq : '<%= session.getAttribute("seq") %>'
				},
				success:function(data){
					$("#title").attr('value', data.title);
					$("#blog").attr('value', data.blog);
					$("#git").attr('value', data.github);
					$("#content").html(data.writing.replaceAll('<br />', '\n'));
				}
			});
		}
	
		function pictures(obj){
			if (obj.files && obj.files[0]) {
				var reader = new FileReader;
				reader.onload = function(data) {
					$(".select_img img").attr("src", data.target.result).width(200).height(300);
				}
				reader.readAsDataURL(obj.files[0]);
			}
		}
	
		function introduceSave(){
			$.ajax({
				url:"/jquery/introWrite",
				type:"POST",
				data:{
					title : $("#title").val(),
					blog : $("#blog").val(),
					github : $("#git").val(),
					writing : $("#content").val().replaceAll('\n', '<br />'),
					picture : "pinture",
					/*$("#select_image").attr("src")*/
				},
				success:function(data){
					if(!data){
						swal("등록 실패");
					} else {
						/* swal("등록 완료"); */
						swal({
							title:"등록완료",
							text:"메인화면으로 이동합니다.",
							icon:"success",
							closeOnClickOutside:false,
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
			<h2>기본 정보</h2>
			<form name="form" id="form" action="">
				<div class="mb-3">
					<label for="title">Title</label> 
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="blog">Blog.</label> 
					<input type="text" class="form-control" name="blog" id="blog" placeholder="블로그 주소를 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="blog">Github.</label> 
					<input type="text" class="form-control" name="git" id="git" placeholder="깃허브 주소를 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="content">Content</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="자신을 잘 표현할 수 있는 글을 작성해주세요"></textarea>
				</div>
				<div class="inputArea">
					<label for="image">이미지</label> 
					<input type="file" id="image" name="image" onchange="pictures(this)"/>
					<div class="select_img"> <img id="select_image" src="" /> </div>
					<%-- <%= request.getRealPath("/") %> --%>
				</div>
			</form>
			<div>
				<input type="button" class="btn btn-sm btn-primary" onclick="introduceSave()" value="저장"/>
				<input type="button" class="btn btn-sm btn-primary" onclick="javascript:location.href='/home/resume'" value="뒤로"/>
				<!-- <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button> -->
			</div>
		</div>
	</article>
</body>
</html>
