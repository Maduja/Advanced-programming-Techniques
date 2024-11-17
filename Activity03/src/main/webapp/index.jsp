<html>
<body>
	<h2>Employee Registration</h2>
	<%
	if (request.getParameter("s") != null) {
		int s = Integer.parseInt(request.getParameter("s"));
		String msg = "";
		switch (s) {
		case 0:
			msg = "Error Occured";
			break;
		case 1:
			msg = "Successfully saved";
			break;
		}
		out.println("<h4>" + msg + "</h4>");		
	}
	%>
	<form action="EmployeeHandler?n" method="post">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="empid"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>
