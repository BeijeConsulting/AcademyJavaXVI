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

	<form action="./user_page" method="get">
		<input type="submit" value="Indietro">
	</form>

	<p>${logged_user.name}${logged_user.surname}, ecco i tuoi indirizzi</p>
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
		<c:forEach var="address" items="${logged_user.addresses}">
			<tr>
				<td align="left">${address.label}</td>
				<td align="left">${address.fullName}</td>
				<td align="left">${address.country}</td>
				<td align="left">${address.streetAddress}</td>
				<td align="left">${address.zipcode}</td>
				<td align="left">${address.telephone}</td>
				<td align="left">${address.instructions}</td>
				<td align="left">[edit/delete]</td>
			</tr>
		</c:forEach>
	</table>

	<form action="./add_address" method="get">
		<input type="submit" value="Aggiungi indirizzo">
	</form>

</body>
</html>