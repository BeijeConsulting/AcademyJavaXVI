<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page!</title>
</head>
<body>
<c:choose>
	<c:when test="${empty logged_user}">Mi dispiace, non ci sono dettagli per te...</c:when>
	
	<form action="./login" method="get">
		<input type="submit" value="Back to login">
	</form>
	
	<c:otherwise>
		<p><strong>Welcome ${logged_user.name}!</strong></p>

		<p>Ecco i tuoi dettagli:</p><br>
			${logged_user}
	</c:otherwise>
</c:choose>
</body>
</html>