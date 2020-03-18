<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservation Not Available</title>
</head>
<body>
	Your reservation for ${exception.courtName} is no available on <fmt:formatDate 
	value="${exception.date}" pattern="yyyy-MM-dd"/> at ${exception.hour}:00.
</body>
</html>