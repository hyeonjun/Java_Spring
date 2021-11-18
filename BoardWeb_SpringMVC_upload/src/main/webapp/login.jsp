<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body align="center">
	<h1>로그인</h1>
	<hr>
	
	<div align="center">
	<form action="login.do" method="post">
		<table border="1" cellpadding="0"  cellspacing="0">
			<tr>
				<td bgcolor="orange">아이디</td>
				<td><input type="text" name="id" value="${user.id }"></td>
			</tr>
			
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>

<!-- 전송 방식에 다른 요청 처리.
 
	<div align="center">
	<form action="login.do" method="post">
		<table border="1" cellpadding="0"  cellspacing="0">
			<tr>
				<td bgcolor="orange">아이디</td>
				<td><input type="text" name="id" value="${userVO.id }"></td>
			</tr>
			
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password" value="${userVO.password }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
	</div>
 -->
 
 
 <!-- @ModelAttribute("user") : Command 객체 이름 변경
 
 	<div align="center">
	<form action="login.do" method="post">
		<table border="1" cellpadding="0"  cellspacing="0">
			<tr>
				<td bgcolor="orange">아이디</td>
				<td><input type="text" name="id" value="${user.id }"></td>
			</tr>
			
			<tr>
				<td bgcolor="orange">비밀번호</td>
				<td><input type="password" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="로그인" />
				</td>
			</tr>
		</table>
	</form>
	</div>
  -->