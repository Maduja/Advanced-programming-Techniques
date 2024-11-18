<%@page import="my.app.model.Employee"%>
<%
Employee emp = (Employee) request.getAttribute("emp");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	<form action="EmployeeRegistration?u" method="POST">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="empid" value="<%=emp.getEmpid() %>" readonly/></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname" value="<%=emp.getFirstname() %>"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname" value="<%=emp.getLastname() %>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
	<p>
		<a href="EmployeeRegistration?v">View All Employees</a>
	</p>

</body>
</html>