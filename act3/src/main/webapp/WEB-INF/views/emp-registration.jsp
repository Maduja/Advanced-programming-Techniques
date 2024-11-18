<%
String message = "";
if (request.getAttribute("status") != null) {
	if (request.getAttribute("status").equals("1")) {
		message = "Successfully saved";
	} else {
		message = "Error occured";
	}
}
%>

<html>
<body>
	<h2>Employee Registration</h2>
	<h5><%=message%></h5>
	<form action="EmployeeRegistration?n" method="POST">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="EmployeeRegistration?v">View All Employees</a>
	</p>
</body>
</html>
