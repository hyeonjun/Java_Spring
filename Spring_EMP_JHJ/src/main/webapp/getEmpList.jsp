<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jhj.biz.emp.impl.EmpDAO" %>
<%@ page import="com.jhj.biz.emp.EmpVO" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사원 목록</title>
</head>
<body>
	<h1>사원 목록</h1>
	<div align="center">
				<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th width="100">사원번호</th>
				<th width="150">사원이름</th>
				<th width="100">직책</th>
				<th width="200">입사일</th>
				<th width="100">급여</th>
				<th width="100">성과급</th>
				<th width="100">부서번호</th>
			</tr>
			<c:forEach items="${empList}" var="emp">
			<tr>
				<td width="100">${emp.eno }</td>
				<td width="150">
					<a href="getEmp.do?seq=${emp.eno}">
						${eno.ename}
					</a>
				</td>
				<td width="100">${eno.job}</td>
				<td width="200">${eno.hiredate}</td>
				<td width="100">${eno.sale}</td>
				<td width="100">${eno.commission}</td>
				<td width="100">${eno.deptno}</td>
			</tr>
			</c:forEach>
			<%-- <% } %> --%>
		</table>
	</div>
	<br />
	<a href="insertEmp.jsp">새 글 등록</a>
</body>
</html>