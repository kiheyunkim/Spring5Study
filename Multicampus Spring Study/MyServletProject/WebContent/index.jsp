<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이 주석은 소스 보기에서 보인다. -->
	<%-- 이 주석은 소스보기에서 안보인다.
		내장객체(implicit object)
		out:  
	 --%>
	<%
		Date myDate = new Date();
		out.println(myDate);
	%>
	<p>현재 날짜는 <%=myDate %></p>
	<ul><h4><a href="userlist.do">사용자 리스트</a></h4></ul>
</body>
</html>