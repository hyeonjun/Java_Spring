<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Resume Management</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://www.markuptag.com/bootstrap/5/css/bootstrap.min.css">
    <!-- Bootstrap JS -->
    <script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
    function login(userId, password){
    	$.ajax({
    		url:"/jquery/login",
    		type:"POST",
    		data: {
    			userId : userId,
    			password : password,
    		},
    		success:function(data){
    			console.log("===> data : ", data);
    			if(!data){
    				swal("아이디 혹은 비밀번호가 맞지 않습니다.");
    				return false;
    			} else if(data){
    				location.href="/dashboard";
    			}
    		}
    	})
    }
    
    function loginValidation() {
    	const userId = $('#userId').val();
    	const password = $('#password').val();
    	/* console.log(userId);
    	console.log(password); */
    	if(!userId){
    		swal("아이디를 입력하세요");
    		$('#userId').focus();
    		return false;
    	} else if(!password){
    		swal("비밀번호를 입력하세요");
    		return false;
    	} else {
    		login(userId, password);
    	}
    }
    
    function enterKey() {
    	if (event.keyCode == 13){
    		loginValidation();
    	}
    }
    </script>
    <style>
    	#register .hover(
    		
    	)
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="login-form bg-light mt-4 p-4">
                    <form action="" class="row g-3">
                        <h4 align="center"><strong>Welcome Rmgmt!</strong></h4>
                        <div class="col-12">
                            <label>아이디</label>
                            <input type="text" id="userId" class="form-control" placeholder="ID" required="required" onkeyup="enterKey()">
                        </div>
                        <div class="col-12">
                            <label>비밀번호</label>
                            <input type="password" id="password" class="form-control" placeholder="Password" required="required" onkeyup="enterKey()">
                        </div>
                        <div class="col-12">
                        </div>
                        <div class="col-12">
                        	<input type="button" value="로그인" onclick="loginValidation()" class="btn btn-dark float-end">
                            <!-- <button type="submit" class="btn btn-dark float-end">로그인</button> -->
                        </div>
                    </form>
                    <hr class="mt-4">
                    <div class="col-12">
                        <p class="text-center mb-0" onclick="location.href='/home/signUp'">
                        	<label style="cursor:pointer; text-decoration:underline; text-underline-position:under;">회원가입</label>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>