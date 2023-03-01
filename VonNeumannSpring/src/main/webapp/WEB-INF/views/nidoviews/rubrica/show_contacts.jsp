<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elenco contatti</title>
</head>
<body>

	<form action="./menu" method="get">
		<input type="submit" value="Back to menu">
	</form>

	<p>
		<strong>Lista dei contatti</strong>
	</p>
	
	<c:choose>
	<c:when test="${empty rubrica}">NESSUN CONTATTO</c:when>
	<c:otherwise>
		<table>
			<tr>
				<th align="left">ID</th>
				<th align="left">NOME</th>
				<th align="left">COGNOME</th>
				<th align="left">TELEFONO</th>
				<th align="left">EMAIL</th>
				<th align="left">NOTE</th>
			</tr>
			
			<c:forEach var="contact" items="${rubrica}">
				<tr>
					<td align="left">${contact.id}</td>
					<td align="left">${contact.name}</td>
					<td align="left">${contact.surname}</td>
					<td align="left">${contact.telephone}</td>
					<td align="left">${contact.email}</td>
					<td align="left">${contact.note}</td>
				</tr>
			</c:forEach>
		</table>
	</c:otherwise>
	</c:choose>

</body>
</html>