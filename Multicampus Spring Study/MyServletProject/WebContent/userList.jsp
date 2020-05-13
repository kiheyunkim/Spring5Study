<%@page import="myspring.user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<UserVO> users = (List<UserVO>) request.getAttribute("userList");
		out.println(users);
	%>
	${userList}
</body>
</html>