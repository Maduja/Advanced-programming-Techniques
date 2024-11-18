
<%@page import="my.app.model.Employee"%>
<%@page import="my.app.model.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
</head>
<body>
	<h1>View Employee</h1>
	<table border="1">
		<tr>
			<th>Emplyee Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Actions</th>

		</tr>
		<%
		EmployeeDAO empDaoBean = (EmployeeDAO) getServletContext().getAttribute("empDaoBean");
		for (Employee emp : empDaoBean.getEmployeeList()) {
		%>
		<tr>
			<td><%=emp.getEmpid()%></td>
			<td><%=emp.getFirstname()%></td>
			<td><%=emp.getLastname()%></td>
			<td><a href="EmployeeRegistration?d=<%=emp.getEmpid()%>">Delete</a> | <a href="EmployeeRegistration?u=<%=emp.getEmpid()%>">Update</a></td>

		</tr>
		<%
		}
		%>

	</table>
</body>
</html>