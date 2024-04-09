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
<h2>USER DASHBORD</h2>
	<table border="2px">
	<%ResultSet res=(ResultSet)request.getAttribute("userList"); %>
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>User Email</th>
			<th>User Address</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%while(res.next()){ %>
		<tr>
		<td><%=res.getInt("userId") %> </td>
		<td> <%=res.getString("userName") %></td>
		<td> <%=res.getString("userEmail") %></td>
		<td><%=res.getString("userAddress") %> </td>
		<td><a href="updateUser?userId=<%= res.getInt("userId") %>">UPDATE</a></td>
		<td><a href="deleteUser?userId=<%= res.getInt("userId") %>">DELETE</a></td>
		</tr>
		<%} %>

	</table>
	
</body>
<a href="index.jsp">Back To Home</a>
</html>