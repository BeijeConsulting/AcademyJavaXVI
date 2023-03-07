<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi indirizzi</title>
</head>
<body>
	<p>${logged_user.name} ${logged_user.surname}, ecco i tuoi indirizzi</p>
	<table>
		<tr>
			<th align="left">Label</th>
			<th align="left">Full Name</th>
			<th align="left">Country</th>
			<th align="left">Street Address</th>
			<th align="left">Zipcode</th>
			<th align="left">Telephone</th>
			<th align="left">Instructions</th>
			<th align="center">Actions</th>
		</tr>
		<tr>
			<td>${logged_user.addressesTable}</td>
		</tr>
	</table>
	
	<form action="./add_address" method="get">
		<input type="submit" value="Aggiungi indirizzo">
	</form>

</body>
</html>