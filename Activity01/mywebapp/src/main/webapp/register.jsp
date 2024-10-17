<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.classes.DbConnector"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="com.classes.MD5"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<%
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String uname = request.getParameter("uname");
String password = MD5.getMd5(request.getParameter("password"));


String query = "INSERT INTO user(firstname,lastname,username,password) VALUES(?,?,?,?)";
PreparedStatement pstmt = DbConnector.getConnection().prepareStatement(query);
pstmt.setString(1, fname);
pstmt.setString(2, lname);
pstmt.setString(3, uname);
pstmt.setString(4, password);

if(pstmt.executeUpdate()>0){
	out.println("Successfully Saved");
}else{
	out.println("Error Occurred");
}
%>
</body>
</html>