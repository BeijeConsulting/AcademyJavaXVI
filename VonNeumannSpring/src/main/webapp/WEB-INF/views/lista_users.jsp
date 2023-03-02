<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA UTENTI</title>
</head>

<body>
LISTA UTENTI<br><br>

<c:choose>
	<c:when test="${empty users}">NESSUN UTENTE</c:when>
	<c:otherwise>
		<c:forEach var="user" items="${users}">
			${user.id}
            ${user.name}</br>
            ${user.lastName}</br>
            ${user.email}<br>
            ${user.description}<br>
            ${user.telephone}<br>
            ${user.birthDate}<br>
            
			<br>
			---------------------------<br><br>
		</c:forEach>
	</c:otherwise>
</c:choose>

</body>
</html>