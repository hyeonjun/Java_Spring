<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>기본 에러 화면</title>
</head>
<body>
	<table width="100%" border="1" cellpadding="0"  cellspacing="0">
		<tr>
			<td align="center">
				<strong>
				NullPointer 에러 페이지 입니다. <br/>
				에러 내용은 아래와 같습니다.	
				</strong>			
			</td>
		</tr>
	</table>
	<table width="100%" border="1" cellpadding="0"  cellspacing="0">
		<tr>
			<td align="center">
				Message : ${exception}
			</td>
		</tr>
	</table>
</body>
</html>