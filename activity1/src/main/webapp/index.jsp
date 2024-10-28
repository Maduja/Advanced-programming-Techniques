<% 
String msg = "";
if(request.getParameter("s")!=null){
	if(request.getParameter("s").equals("1")){
		out.println("Success");
	}else{
		out.println("failed");
	}
}
%>
<html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<form action="register.jsp" method="post">
		<table>
			<tr>
				<td>Firstname</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Lastname</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="uname"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form>
</body>
</html>