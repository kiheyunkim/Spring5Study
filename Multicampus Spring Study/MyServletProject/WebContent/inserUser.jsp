<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>사용자 등록 화면</h1>
   <form action="userInsert.do" method="post">
      <input type="hidden" name="cmd" value="user_insert">
      UserID : <input type="text" name="userid"><br />
      Name : <input type="text" name="name"><br />
      Gender :
      <input type="radio" name="gender" value="남">남
      <input type="radio" name="gender" value="여">여
      <br>
      City : 
      <select name="city">
         <c:forEach var="cityName" items="${sessionScope.cityList}">
            <option value="${cityName}">${cityName}</option>
         </c:forEach>
      </select>
      <br>
      <input type="submit" value="등록">
   </form>
</body>
</html>