<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 새로운 글 등록 --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사원 등록</title>
</head>
<body>
	<h1>글 등록</h1>
	<hr />
	<div align="center">
		<form action="insertEmp.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>사원이름</td>
					<td><input type="text" name="ename" required="required" /></td>
				</tr>
				<tr>
					<td>직책</td>
					<td><input type="text" name="job" required="required" /></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="text" name="hiredate" required="required" /></td>
				</tr>
				<tr>
					<td>급여</td>
					<td><input type="text" name="sale" required="required" /></td>
				</tr>
				<tr>
					<td>성과급</td>
					<td><input type="text" name="commission" required="required" /></td>
				</tr>
				<tr>
					<td>부서번호</td>
					<td><input type="text" name="deptno" required="required" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="글 등록" /></td>
					<td><input type="reset" value="취소" /></td>
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<a href="getEmpList.jsp">사원 목록</a>
</body>
</html>