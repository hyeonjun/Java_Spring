<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- <!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
	Bootstrap CSS
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> -->
	<style>
		.input-form {
			max-width: 680px;
			margin-top: 80px;
			padding: 32px;
			background: #fff;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
			-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
			box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
		}
		.id-input {
			width:50%;
		}
		.row {
			justify-content:space-between;
		}
		.col-md-6{
			width:75%;
		}
	</style>

	<script>
		var IdCheck = false;
		
		function init() {
			document.getElementById("validation").value = "중복 확인";
		}
		
		function signUp(){
			$.ajax({
				url:"/jquery/signUp",
				type:"POST",
				data:{
					userId:$("#userid").val(),
					password:$("#password").val(),
					nickname:$("#name").val(),
					email:$("#email").val(),
					phone:$("#phone").val()
				},
				success:function(data){
					if(data){
						swal("회원가입이 완료되었습니다.");
						swal({
							titile:"가입 완료",
							text:"회원가입을 축하드립니다.",
							icon:"success",
							closeOnClickOutside:false,
							buttons:{
								confirm:{
									text:"로그인 창으로",
									value:true
								}
							}
						}).then((result) => {
							if(result){
								location.href="/home/login";
							}
						});
					} else {
						swal("가입이 불가능합니다.");
						return false;
					}
				}
			})
		}
		
		function double_id(userId) {
			$.ajax({
				url:"/jquery/idCheck",
				type:"POST",
				data:{
					userId:userId
				},
				success:function(data){
					if(!data){
						swal("이미 등록된 아이디입니다.");
						// return false;
					} else {
						swal("사용가능한 아이디 입니다.");
						document.getElementById("validation").value = "회원 가입";
						IdCheck = true;
						// return true;
					}
				}
			})	
		}
	
		function signUpValidation() {
			const userId = $("#userid").val();
			const password = $("#password").val();
			const password_check = $("#password_check").val();
			const name = $("#name").val();
			const email = $("#email").val();
			const phone = $("#phone").val();
			if(!userId){
				swal("아이디를 입력해주세요.");
				$("#userid").focus();
			} else {
				if(!IdCheck && userId && userId.length > 4){ // ID 중복확인
					double_id(userId);
				} else if(!password && password.length < 8){
					swal("비밀번호를 입력해주세요.");
					$("#password").focus();
				} else if(!password_check){
					swal("비밀번호를 확인해주세요.");
					$("#password_check").focus();
				} else if (password != password_check) {
					swal("올바른 비밀번호를 입력해주세요.");
					$("#password_check").focus();
				} else if(!name || name.length < 2){
					swal("이름을 입력해주세요.");
					$("#name").focus();
				} else if(!email){
					swal("올바른 이메일을 입력해주세요.");
					$("#email").focus();
				} else if(!phone || phone.length != 13){
					swal("올바른 번호를 입력해주세요.");
					$("#phone").focus();
				} else{
					signUp();
				}
			}
		}
		
		function idValidation(){
			IdCheck = false;
			document.getElementById("validation").value = "중복 확인";
		}
	</script>
</head>
<body onload="init()">
	<%@ include file="../common/header.jsp" %>
	<% if(session.getAttribute("user") != null){
			response.sendRedirect("/introduce/write");
		}
	%>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form id="register">
					<div class="mb-3">
						<label for="userid">아이디</label> 
						<input type="text" class="form-control" id="userid" name="userid" 
						placeholder="아이디를 입력해주세요." required="required" onchange="idValidation()" maxlength="20">
					</div>
					<div class="mb-3">
						<label for="password">비밀번호</label> 
						<input type="password" class="form-control" id="password" name="password" maxlength="16" placeholder="8~16자 영문 대소문자, 숫자, 특수문자를 사용하세요." required="required">
					</div>
					<div class="mb-3">
						<label for="password_check">비밀번호 확인</label> 
						<input type="password" class="form-control" id="password_check" name="password_check" maxlength="16" placeholder="위와 동일한 비밀번호를 입력해주세요." required="required">
					</div>
					<div class="mb-3">
						<label for="name">이름</label> 
						<input type="text" class="form-control" id="name" name="name" placeholder="본인 이름을 입력해주세요." required="required">
					</div>
					<div class="mb-3">
						<label for="email">이메일</label> 
						<input type="email" class="form-control" id="email" name="email" placeholder="test@example.com" required="required">
					</div>
					<div class="mb-3">
						<label for="phone">핸드폰 번호</label> 
						<input type="text" class="form-control" id="phone" name="phone" placeholder="010-1234-1234" maxlength="13" required="required">
					</div>
					<div class="mb-4">
						<input type="button" class="btn btn-primary btn-lg btn-block" id="validation" onclick="signUpValidation()">
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>

