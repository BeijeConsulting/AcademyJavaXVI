<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME PAGE</title>
</head>
<body>
	<p><strong>Ciao ${logged_user.name}!</strong></p>

	<p>Ecco i tuoi dettagli:</p>
	<br>
	<table>
		<tr>
			<th align="left">Name</th>
			<th align="left">Surname</th>
			<th align="left">Telephone</th>
			<th align="left">E-mail</th>
			<th align="left">Birth Date</th>
		</tr>
		<tr>
			<td>${logged_user.tableFormat}</td>
		</tr>
	</table>
	
	<p>Cosa vuoi fare?</p>
	
	<form action="./edit_user" method="get">
		<input type="submit" value="Modifica dettagli">
	</form>
	
	<form action="./" method="get">
		<input type="submit" value="Visualizza i miei ordini">
	</form>
	
		<form action="./addresses" method="get">
		<input type="submit" value="Visualizza i miei indirizzi">
	</form>
	
</body>
</html>