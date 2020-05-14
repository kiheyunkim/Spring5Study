<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--@page import="java.util.List,jdbc.user.vo.UserVO"--%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	   List<UserVO> users = (List<UserVO>)request.getAttribute("userList");
	   out.println(users);	
	--%>
	<%--EL(Expression Language) --%>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>주소</th>
		</tr>
		<c:forEach  var="user" items="${userList}">
			<tr>
			    <%--UserVO.getUserId()--%>
				<td>${user.userId}</td>
				<td>${user.name}</td>
				<td>${user.gender}</td>
				<td>${user.city}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

