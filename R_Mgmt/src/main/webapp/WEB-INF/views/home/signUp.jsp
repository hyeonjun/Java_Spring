<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
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
			box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
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
						}).then(function(result){
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
				} else if(password){
					const reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
					if(!reg.test(password)){
						swal("비밀번호는 8자리 이상, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.");
					} else if(!password_check){
						swal("비밀번호를 확인해주세요.");
						$("#password_check").focus();
					} else if (password != password_check) {
						swal("비밀번호가 맞지 않습니다.");
						$("#password_check").focus();
					} else if(!name || name.length < 2){
						swal("이름을 입력해주세요.");
						$("#name").focus();
					} else if(!email){
						swal("올바른 이메일을 입력해주세요.");
						$("#email").focus();
					} else if(email){
						const regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
						if(!regEmail.test(email)){
							swal("올바른 이메일을 입력해주세요.");
						} else if(!phone){
							swal("올바른 휴대폰 번호를 입력해주세요.");
							$("#phone").focus();
						} else if(phone){
							const regPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
							if(!regPhone.test(phone)){
							swal("올바른 휴대폰 번호를 입력해주세요.");
							} else{
								signUp();
							}
						}
					}
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

