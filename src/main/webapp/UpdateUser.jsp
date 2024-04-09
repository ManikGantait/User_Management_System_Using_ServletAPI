<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%ResultSet res=(ResultSet)request.getAttribute("getUpdateDetails") ;%>
<form action="updated" method="post">
<%while(res.next()){ %>
<input type="number" name="userId" value="<%= res.getInt("userId")%>">
<input type="text" name="userName" value="<%= res.getString("userName")%>">
<input type="email" name="userEmail" value="<%= res.getString("userEmail")%>" >
<input type="text" name="userAddress" value="<%= res.getString("userAddress")%>">
<input type="submit" value="update">
<%} %>
</form>
</body>
</html>