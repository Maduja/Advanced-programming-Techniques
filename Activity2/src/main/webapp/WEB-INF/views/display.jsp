<%@page import="app.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered User</title>
</head>
<body>
<%
User user = (User)request.getAttribute("usermodel");
%>
<h3>First name: <%=user.getFirstname() %></h3>
<h3>Lastt name: <%=user.getLastname() %></h3>
<h3>User name: <%=user.getUsername() %></h3>
<h3>Password: <%=user.getPassword() %></h3>
</body>
</html>