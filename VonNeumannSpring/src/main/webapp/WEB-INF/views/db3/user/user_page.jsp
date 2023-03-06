<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>
	<p><strong>Welcome ${user.name}!</strong></p>

	<p>Ecco i tuoi dettagli:</p>
	<br>
	<table>
		<tr>
			<th align="left">User Id</th>
			<th align="left">Name</th>
			<th align="left">Surname</th>
			<th align="left">Telephone</th>
			<th align="left">E-mail</th>
			<th align="left">Password</th>
			<th align="left">Birth Date</th>
			<th align="left">Created At</th>
			<th align="left">Disabled At</th>
		</tr>
		<tr>
			<td>${user.tableFormat}</td>
		</tr>
	</table>
</body>
</html>